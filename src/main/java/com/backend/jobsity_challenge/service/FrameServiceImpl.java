package com.backend.jobsity_challenge.service;

import com.backend.jobsity_challenge.model.Frame;
import com.backend.jobsity_challenge.model.Roll;
import com.backend.jobsity_challenge.validator.FrameValidatorImpl;
import com.backend.jobsity_challenge.validator.RollValidatorImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrameServiceImpl implements FrameService {

    private static final int FRAMES_LIMIT = 10;
    private RollValidatorImpl rollValidator;
    private FrameValidatorImpl frameValidator;

    public FrameServiceImpl() {
        rollValidator = new RollValidatorImpl();
        frameValidator = new FrameValidatorImpl();
    }

    /**
     * The method takes a list of player rolls for a given game and returns the frames
     * for that game based on the provided rolls
     * @param rolls the rolls of a given player for a given game
     * @return the list of frames generated from the rolls list
     */
    @Override
    public List<Frame> createGameFrames(List<Roll> rolls) {
        List<Frame> result = new ArrayList<>();
        boolean shouldSkipNext = false;
        boolean lastFrameProcessed = false;

        for (int i = 0; i < rolls.size(); i++) {
            if (shouldSkipNext || lastFrameProcessed) {
                shouldSkipNext = false;
                continue;
            }

            Frame frame;

            Roll currentRoll = rolls.get(i);
            Roll nextRoll = rolls.get(i + 1);
            Roll overNextRoll = i + 2 < rolls.size() ? rolls.get(i + 2) : null;

            frame = createSingleFrame(currentRoll, nextRoll, overNextRoll, result.size());

            result.add(frame);

            shouldSkipNext = shouldSkipNextFrame(frame);
            lastFrameProcessed = isLastFrameProcessed(result);
        }

        frameValidator.validateFrameListLength(result);

        return result;
    }

    private boolean isLastFrameProcessed(List<Frame> result) {
        return result.size() == FRAMES_LIMIT;
    }

    private boolean shouldSkipNextFrame(Frame frame) {
        return !frame.isStrike();
    }

    private Frame createSingleFrame(Roll currentRoll, Roll nextRoll, Roll overNextRoll, int resultSize) {
        Frame frame;
        if (rollValidator.isStrike(currentRoll)) {
            frame = createStrikeFrame(currentRoll, nextRoll, overNextRoll, resultSize);
        } else {
            if (rollValidator.isSpare(currentRoll, nextRoll)) {
                frame = createSpareFrame(currentRoll, nextRoll, overNextRoll);
            } else {
                frame = createStandardFrame(currentRoll, nextRoll);
            }
        }
        return frame;
    }

    private Frame createStrikeFrame(Roll currentRoll, Roll nextRoll, Roll overNextRoll, int resultSize) {
        Frame frame;

        if (resultSize == FRAMES_LIMIT - 1) {
            frame = createSpareFrame(currentRoll, nextRoll, overNextRoll);
            frame.addRoll(overNextRoll);
            frame.setSpare(false);
            frame.setStrike(true);
        } else {
            frame = new Frame();
            frame.setStrike(true);
            frame.addRoll(currentRoll);
            frame.setScore(currentRoll.getPins() + nextRoll.getPins() + overNextRoll.getPins());

        }

        return frame;
    }

    private Frame createSpareFrame(Roll currentRoll, Roll nextRoll, Roll overNextRoll) {
        Frame frame = createStandardFrame(currentRoll, nextRoll);
        frame.setScore(frame.getScore() + overNextRoll.getPins());
        frame.setSpare(true);

        return frame;
    }

    private Frame createStandardFrame(Roll currentRoll, Roll nextRoll) {
        Frame frame = new Frame();
        frame.addRoll(currentRoll);
        frame.addRoll(nextRoll);
        frame.setScore(currentRoll.getPins() + nextRoll.getPins());

        return frame;
    }
}
