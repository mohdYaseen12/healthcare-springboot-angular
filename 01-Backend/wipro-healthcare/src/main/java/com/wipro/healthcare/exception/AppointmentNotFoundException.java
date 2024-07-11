package com.wipro.healthcare.exception;

@SuppressWarnings("serial")
public class AppointmentNotFoundException extends RuntimeException {

	public AppointmentNotFoundException(String message) {
		super(message);
	}
}
