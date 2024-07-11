package com.wipro.healthcare.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.healthcare.dto.PatientDto;
import com.wipro.healthcare.entities.Patient;

public interface IPatientService {

	ResponseEntity<Patient> registerPatient(PatientDto patientDto);

	ResponseEntity<Patient> updatePatient(Long patientId, PatientDto patientDto);

	ResponseEntity<Patient> getPatientById(Long patientId);

	ResponseEntity<List<Patient>> getAllPatients();

	ResponseEntity<String> deletePatientById(Long patientId);

}
