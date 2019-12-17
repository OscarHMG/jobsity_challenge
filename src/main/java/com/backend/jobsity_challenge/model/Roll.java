package com.backend.jobsity_challenge.model;

public class Roll {

    private static final String FOUL_MARK = "f";
    private String value;
    private int pins;

    public Roll(String value) {
        this.value = value;
        if (FOUL_MARK.equalsIgnoreCase(value)) {
            this.pins = 0;
        } else {
            this.pins = Integer.parseInt(value);
        }
    }

    public String getValue() {
        return value;
    }

    public int getPins() {
        return pins;
    }

    @Override
    public boolean equals(Object obj) {
        Roll otherRoll = (Roll) obj;
        return this.value.equalsIgnoreCase(otherRoll.value);
    }
}
