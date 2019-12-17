package com.backend.jobsity_challenge.validator;

import com.backend.jobsity_challenge.model.Frame;

import java.util.List;

public interface FrameValidator {
    void validateFrameListLength(List<Frame> frames);
}
