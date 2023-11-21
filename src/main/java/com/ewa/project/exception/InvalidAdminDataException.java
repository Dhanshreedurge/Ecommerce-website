package com.ewa.project.exception;

@SuppressWarnings("serial")
public class InvalidAdminDataException extends RuntimeException {
    public InvalidAdminDataException(String message) {
        super(message);
    }
}