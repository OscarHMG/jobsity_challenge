package com.backend.jobsity_challenge.exception;

public class ValueOutOfBoundsException extends RuntimeException {
    public ValueOutOfBoundsException() {
        super();
    }
    public ValueOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }
    public ValueOutOfBoundsException(String message) {
        super(message);
    }
    public ValueOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}
