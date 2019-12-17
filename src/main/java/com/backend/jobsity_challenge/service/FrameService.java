package com.backend.jobsity_challenge.service;

import com.backend.jobsity_challenge.model.Frame;
import com.backend.jobsity_challenge.model.Roll;

import java.util.List;

public interface FrameService {
    List<Frame> createGameFrames(List<Roll> rolls);
}
