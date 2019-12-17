package com.backend.jobsity_challenge.exception;

public class FileReadingException extends RuntimeException {
    public FileReadingException() {
        super();
    }
    public FileReadingException(String message, Throwable cause) {
        super(message, cause);
    }
    public FileReadingException(String message) {
        super(message);
    }
    public FileReadingException(Throwable cause) {
        super(cause);
    }
}
