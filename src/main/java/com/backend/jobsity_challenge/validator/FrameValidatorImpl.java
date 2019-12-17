package com.backend.jobsity_challenge.validator;

import com.backend.jobsity_challenge.exception.ValueOutOfBoundsException;
import com.backend.jobsity_challenge.model.Frame;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FrameValidatorImpl implements FrameValidator {

    /**
     * The method validates that a given frame list is as long as a game is, that is 10 frames
     * @param frames the list of frames that comprise a game
     */
    public void validateFrameListLength(List<Frame> frames) {
        if (frames.size() != 10) {
            throw new ValueOutOfBoundsException("There were more than 10 frames allocated for one of the players.");
        }
    }
}
