package com.wipro.healthcare.exception;

@SuppressWarnings("serial")
public class ConsultationNotFoundException extends RuntimeException {

	public ConsultationNotFoundException(String message) {
		super(message);
	}
}