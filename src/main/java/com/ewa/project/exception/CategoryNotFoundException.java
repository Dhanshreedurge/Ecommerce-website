package com.ewa.project.exception;

@SuppressWarnings("serial")
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}