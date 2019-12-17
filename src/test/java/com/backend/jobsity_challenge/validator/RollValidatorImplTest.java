package com.backend.jobsity_challenge.validator;

import com.backend.jobsity_challenge.exception.InvalidDataException;
import com.backend.jobsity_challenge.exception.ValueOutOfBoundsException;
import com.backend.jobsity_challenge.model.Roll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RollValidatorImplTest {

    private RollValidator rollValidator;

    @Before
    public void setUp() {
        rollValidator = new RollValidatorImpl();
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void failWhenRollValueIsBelowTheAccepted() {
        rollValidator.validateRollValue("-1");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void failWhenRollValueIsOverTheAccepted() {
        rollValidator.validateRollValue("11");
    }

    @Test(expected = InvalidDataException.class)
    public void failWhenRollValueIsNotAccepted() {
        rollValidator.validateRollValue("a");
    }

    @Test
    public void successWhenValueIsInTheRange() {
        String lowestValue = rollValidator.validateRollValue("0");
        String middleValue = rollValidator.validateRollValue("5");
        String highestValue = rollValidator.validateRollValue("10");
        String firstFoulValue = rollValidator.validateRollValue("f");
        String secondFoulValue = rollValidator.validateRollValue("F");

        assertEquals("0", lowestValue);
        assertEquals("5", middleValue);
        assertEquals("10", highestValue);
        assertEquals("f", firstFoulValue);
        assertEquals("F", secondFoulValue);
    }

    @Test
    public void validateStrikeWhenIsStrike() {
        Roll roll = new Roll("10");
        boolean isStrike = rollValidator.isStrike(roll);
        assertTrue(isStrike);
    }

    @Test
    public void validateNoStrikeWhenIsNotStrike() {
        Roll roll = new Roll("9");
        boolean isStrike = rollValidator.isStrike(roll);
        assertFalse(isStrike);
    }

    @Test
    public void validateSpareWhenIsSpare() {
        Roll firstRoll = new Roll("1");
        Roll secondRoll = new Roll("9");
        boolean isSpare = rollValidator.isSpare(firstRoll, secondRoll);
        assertTrue(isSpare);
    }

    @Test
    public void validateNoSpareWhenIsNotSpare() {
        Roll firstRoll = new Roll("1");
        Roll secondRoll = new Roll("8");
        boolean isSpare = rollValidator.isSpare(firstRoll, secondRoll);
        assertFalse(isSpare);
    }
}