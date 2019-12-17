package com.backend.jobsity_challenge.service;

import com.backend.jobsity_challenge.model.Roll;

import java.util.List;
import java.util.Map;

public interface ParseService {
    Map<String, List<Roll>> parse(String filePath);
}
