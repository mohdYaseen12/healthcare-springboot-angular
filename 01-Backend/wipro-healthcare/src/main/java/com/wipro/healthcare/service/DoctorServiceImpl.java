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

import com.wipro.healthcare.dto.DoctorDto;
import com.wipro.healthcare.entities.Doctor;
import com.wipro.healthcare.exception.DoctorNotFoundException;
import com.wipro.healthcare.repositories.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService, UserDetailsService {

	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Doctor doctor = doctorRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with Email: " + email));
		return new User(doctor.getEmail(), doctor.getPassword(), new ArrayList<>());
	}

	@Override
	public ResponseEntity<Doctor> getDoctorById(Long doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).get();
		if (doctor != null) {
			return ResponseEntity.ok(doctor);
		} else
			throw new DoctorNotFoundException("Doctor with Id: " + doctorId + " was not found.");
	}

	@Override
	public ResponseEntity<Doctor> registerDoctor(DoctorDto doctorDto) {
		Doctor doctor = new Doctor();
		doctor.setAppointments(doctorDto.getAppointments());
		doctor.setDesignation(doctorDto.getDesignation());
		doctor.setEmail(doctorDto.getEmail());
		doctor.setPassword(encoder.encode(doctorDto.getPassword()));
		doctor.setExperience(doctorDto.getExperience());
		doctor.setFirstName(doctorDto.getFirstName());
		doctor.setLastName(doctorDto.getLastName());
		doctor.setMedicalRecords(doctorDto.getMedicalRecords());
		doctor.setPhoneNumber(doctorDto.getPhoneNumber());
		doctor.setQualification(doctorDto.getQualification());
		doctor.setSpecialty(doctorDto.getSpecialty());
		Doctor savedDoctor = doctorRepository.save(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
	}

	@Override
	public ResponseEntity<Doctor> updateDoctor(Long doctorId, DoctorDto doctorDetails) {
		Doctor doctor = doctorRepository.findById(doctorId).get();
		if (doctor != null) {
			if (doctorDetails.getFirstName() != null)
				doctor.setFirstName(doctorDetails.getFirstName());
			if (doctorDetails.getLastName() != null)
				doctor.setLastName(doctorDetails.getLastName());
			if (doctorDetails.getEmail() != null)
				doctor.setEmail(doctorDetails.getEmail());
			if (doctorDetails.getPassword() != null)
				doctor.setPassword(doctorDetails.getPassword());
			if (doctorDetails.getDesignation() != null)
				doctor.setDesignation(doctorDetails.getDesignation());
			if (doctorDetails.getPhoneNumber() != null)
				doctor.setPhoneNumber(doctorDetails.getPhoneNumber());
			if (doctorDetails.getSpecialty() != null)
				doctor.setSpecialty(doctorDetails.getSpecialty());
			if (doctorDetails.getExperience() != 0)
				doctor.setExperience(doctorDetails.getExperience());
			if (doctorDetails.getQualification() != null)
				doctor.setQualification(doctorDetails.getQualification());
			Doctor updatedDoctor = doctorRepository.save(doctor);
			return ResponseEntity.ok(updatedDoctor);
		} else
			throw new DoctorNotFoundException("Doctor with Id: " + doctorId + " was not found.");
	}

	@Override
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctors = doctorRepository.findAll();
		if (!doctors.isEmpty()) {
			return ResponseEntity.ok(doctors);
		} else
			throw new DoctorNotFoundException("Doctor List is Empty.");
	}

	@Override
	public ResponseEntity<String> deleteDoctor(Long doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).get();
		if (doctor != null) {
			doctorRepository.delete(doctor);
			return ResponseEntity.ok("Doctor deleted successfully");
		} else
			throw new DoctorNotFoundException("Doctor with Id: " + doctorId + " was not found.");
	}
}
