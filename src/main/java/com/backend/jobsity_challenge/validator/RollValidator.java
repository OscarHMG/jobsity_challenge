package com.backend.jobsity_challenge.validator;

import com.backend.jobsity_challenge.model.Roll;

public interface RollValidator {
    String validateRollValue(String rollValue);
    boolean isStrike(Roll roll);
    boolean isSpare(Roll firstRoll, Roll secondRoll);
}
