package com.backend.jobsity_challenge.model;


import java.util.ArrayList;
import java.util.List;

public class Frame {
    private List<Roll> rolls;
    private boolean strike;
    private boolean spare;
    private int score;

    public Frame() {
        this.rolls = new ArrayList<>();
        this.strike = false;
        this.spare = false;
    }

    public void addRoll(Roll roll) {
        this.rolls.add(roll);
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public boolean isStrike() {
        return strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public int getScore() {
        return this.score;
    }
}
