package com.wipro.healthcare.dto;

import java.util.Date;
import java.util.List;

import com.wipro.healthcare.entities.Appointment;
import com.wipro.healthcare.entities.MedicalRecord;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
	
	private final String role = "PATIENT";

	Long patientId;
	String firstName;
	String lastName;
	String gender;
	String email;
	String password;
	String phoneNumber;
	Date dateOfBirth;
	String address;
	List<Appointment> appointment;
	List<MedicalRecord> medicalRecords;
	
}
