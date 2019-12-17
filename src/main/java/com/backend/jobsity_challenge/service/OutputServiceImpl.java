package com.backend.jobsity_challenge.service;

import com.backend.jobsity_challenge.model.Frame;
import org.springframework.stereotype.Service;

@Service
public class OutputServiceImpl implements OutputService {

    private static final String STRIKE_MARK = "X";
    private static final String SPARE_MARK = "/";

    /**
     * The method takes a frame and creates a String representing a strike
     * with several rolls in the ten-pin bowling scoring notation.
     * This is intended to prepare
     * @param frame the frame about to being printed
     * @return the string ready to be printed
     */
    @Override
    public String prepareMultiRollStrikeLine(Frame frame) {
        return STRIKE_MARK + "\t" +
                frame.getRolls().get(1).getValue() + "\t" +
                getThirdRollIfExist(frame);
    }

    private String getThirdRollIfExist(Frame frame) {
        String value = "";

        if (frame.getRolls().size() == 3) {
            value = frame.getRolls().get(2).getValue();
        }

        return value;
    }

    /**
     * The method takes a frame and creates a String representing it in the ten-pin
     * bowling scoring notation
     * @param frame the frame about to being printed
     * @return the string ready to be printed
     */
    @Override
    public String prepareSingleRollStrikeLine(Frame frame) {
        return "\t" + STRIKE_MARK + "\t";
    }

    /**
     * The method takes a frame and creates a String representing it in the ten-pin
     * bowling scoring notation
     * @param frame the frame about to being printed
     * @return the string ready to be printed
     */
    @Override
    public String prepareSpareLine(Frame frame) {
        return frame.getRolls().get(0).getValue() + "\t" +
                SPARE_MARK + "\t";
    }

    /**
     * The method takes a frame and creates a String representing it in the ten-pin
     * bowling scoring notation
     * @param frame the frame about to being printed
     * @return the string ready to be printed
     */
    @Override
    public String prepareStandardLine(Frame frame) {
        return frame.getRolls().get(0).getValue() + "\t" +
                frame.getRolls().get(1).getValue() + "\t" +
                getThirdRollIfExist(frame);
    }
}
