package com.wipro.healthcare.exception;

@SuppressWarnings("serial")
public class MedicalRecordNotFoundException extends RuntimeException {

	public MedicalRecordNotFoundException(String message) {
		super(message);
	}
}