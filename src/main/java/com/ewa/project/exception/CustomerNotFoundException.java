package com.ewa.project.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
