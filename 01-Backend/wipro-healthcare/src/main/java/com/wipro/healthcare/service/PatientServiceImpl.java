package com.wipro.healthcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.healthcare.dto.PatientDto;
import com.wipro.healthcare.entities.Patient;
import com.wipro.healthcare.exception.PatientNotFoundException;
import com.wipro.healthcare.repositories.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService, UserDetailsService {

	@Autowired
	private IPatientRepository patientRepository;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Patient patient = patientRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with Email: " + email));
		return new User(patient.getEmail(), patient.getPassword(), new ArrayList<>());
	}

	@Override
	public ResponseEntity<Patient> registerPatient(PatientDto patientDto) {
		Patient patient = new Patient();
		patient.setAddress(patientDto.getAddress());
		patient.setAppointment(patientDto.getAppointment());
		patient.setDateOfBirth(patientDto.getDateOfBirth());
		patient.setEmail(patientDto.getEmail());
		patient.setPassword(encoder.encode(patientDto.getPassword()));
		patient.setFirstName(patientDto.getFirstName());
		patient.setLastName(patientDto.getLastName());
		patient.setMedicalRecords(patientDto.getMedicalRecords());
		patient.setPhoneNumber(patientDto.getPhoneNumber());
		Patient savedPatient = patientRepository.save(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
	}

	@Override
	public ResponseEntity<Patient> updatePatient(Long patientId, PatientDto patientDto) {
		Patient patient = patientRepository.findById(patientId).get();
		if (patient != null) {
			if (patientDto.getFirstName() != null)
				patient.setFirstName(patientDto.getFirstName());
			if (patientDto.getLastName() != null)
				patient.setLastName(patientDto.getLastName());
			if (patientDto.getGender() != null)
				patient.setGender(patientDto.getGender());
			if (patientDto.getEmail() != null)
				patient.setEmail(patientDto.getEmail());
			if (patientDto.getPhoneNumber() != null)
				patient.setPhoneNumber(patientDto.getPhoneNumber());
			if (patientDto.getDateOfBirth() != null)
				patient.setDateOfBirth(patientDto.getDateOfBirth());
			if (patientDto.getAddress() != null)
				patient.setAddress(patientDto.getAddress());
			if (patientDto.getAppointment() != null)
				patient.setAppointment(patientDto.getAppointment());
			if (patientDto.getMedicalRecords() != null)
				patient.setMedicalRecords(patientDto.getMedicalRecords());
			Patient updatedPatient = patientRepository.save(patient);
			return ResponseEntity.ok(updatedPatient);
		} else
			throw new PatientNotFoundException("Patient with Id: " + patientId + " not Found.");
	}

	@Override
	public ResponseEntity<Patient> getPatientById(Long patientId) {
		Patient patient = patientRepository.findById(patientId).get();
		if (patient != null) {
			return ResponseEntity.ok(patient);
		} else
			throw new PatientNotFoundException("Patient with Id: " + patientId + " not Found.");
	}

	@Override
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> patients = patientRepository.findAll();
		if (!patients.isEmpty()) {
			return ResponseEntity.ok(patients);
		} else
			throw new PatientNotFoundException("Patient List is Empty.");
	}

	@Override
	public ResponseEntity<String> deletePatientById(Long patientId) {
		patientRepository.deleteById(patientId);
		return new ResponseEntity<String>("Patient with Id: " + patientId + " Deleted Successfully",
				HttpStatus.NO_CONTENT);
	}

}
