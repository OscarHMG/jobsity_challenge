package com.backend.jobsity_challenge.service;

import com.backend.jobsity_challenge.model.Frame;

public interface OutputService {
    String prepareMultiRollStrikeLine(Frame frame);
    String prepareSingleRollStrikeLine(Frame frame);
    String prepareSpareLine(Frame frame);
    String prepareStandardLine(Frame frame);
}
