package com.ewa.project.exception;

@SuppressWarnings("serial")
public class PaymentNotFoundException extends RuntimeException {

	public PaymentNotFoundException(String message) {
		super(message);
	}
}
