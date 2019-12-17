package com.backend.jobsity_challenge.validator;

import com.backend.jobsity_challenge.exception.InvalidDataException;
import com.backend.jobsity_challenge.exception.ValueOutOfBoundsException;
import com.backend.jobsity_challenge.model.Roll;
import org.springframework.stereotype.Component;

@Component
public class RollValidatorImpl implements RollValidator {

    private static final int STRIKE_MARK = 10;
    private static final String FOUL_MARK = "f";

    /**
     * The method validates the value of a roll and determines where it is valid or not
     * @param rollValue the value of a roll for a certain player
     * @return the same value if its type and value range is accepted
     * @throws ValueOutOfBoundsException if the value is a number out of the valid range [0, 10]
     * @throws InvalidDataException if the value is neither a valid number nor an F
     */
    public String validateRollValue(String rollValue) throws ValueOutOfBoundsException, InvalidDataException {
        try {
            int value = Integer.parseInt(rollValue);
            if (value < 0 || value > 10 ) {
                throw new ValueOutOfBoundsException("A value lower than 0 or higher than 10 was found while reading the knocked down pins list.");
            }
        } catch (NumberFormatException e) {
            if (!FOUL_MARK.equalsIgnoreCase(rollValue)) {
                throw new InvalidDataException("There was invalid data found while trying to read the knocked down pins values.");
            }
        }
        return rollValue;
    }

    /**
     * The method evaluates a roll and determines whether a roll is a strike or not
     * @param roll the roll being evaluated
     * @return whether the roll is a strike or not
     */
    public boolean isStrike(Roll roll) {
        return roll.getPins() == STRIKE_MARK;
    }

    /**
     * The method evaluates the rolls of a frame and determines whether they are a spare or not
     * @param firstRoll the first roll of a frame
     * @param secondRoll the second roll of a frame
     * @return whether the rolls are a spare or not
     */
    public boolean isSpare(Roll firstRoll, Roll secondRoll) {
        return firstRoll.getPins() + secondRoll.getPins() == STRIKE_MARK;
    }
}
