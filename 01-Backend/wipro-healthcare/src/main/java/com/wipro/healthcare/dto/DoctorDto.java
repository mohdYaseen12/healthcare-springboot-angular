package com.wipro.healthcare.dto;

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
public class DoctorDto {
	
	private final String role = "DOCTOR";

	Long doctorId;
	String firstName;
	String lastName;
	String email;
	String password;
    String designation;
	String phoneNumber;
	String specialty;
    int experience;
    String qualification;
	List<Appointment> appointments;
	List<MedicalRecord> medicalRecords;
	
}
