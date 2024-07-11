package com.wipro.healthcare.exception;

@SuppressWarnings("serial")
public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String message) {
        super(message);
    }
}
