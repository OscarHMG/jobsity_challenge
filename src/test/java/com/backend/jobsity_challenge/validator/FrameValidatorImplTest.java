package com.backend.jobsity_challenge.validator;

import com.backend.jobsity_challenge.exception.ValueOutOfBoundsException;
import com.backend.jobsity_challenge.model.Frame;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FrameValidatorImplTest {

    @Autowired
    private FrameValidator frameValidator;

    @Before
    public void setUp() {
        frameValidator = new FrameValidatorImpl();
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void validateMalformedFrameList() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 11; i ++) {
            frames.add(new Frame());
        }
        frameValidator.validateFrameListLength(frames);
    }
}