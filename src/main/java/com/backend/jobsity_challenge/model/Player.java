package com.backend.jobsity_challenge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Frame> frames;

    public Player(String name) {
        this.name = name;
        this.frames = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void addFrames(List<Frame> frames) {
        this.frames.addAll(frames);
    }
}
