package com.backend.jobsity_challenge.exception;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException() {
        super();
    }
    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidDataException(String message) {
        super(message);
    }
    public InvalidDataException(Throwable cause) {
        super(cause);
    }
}
