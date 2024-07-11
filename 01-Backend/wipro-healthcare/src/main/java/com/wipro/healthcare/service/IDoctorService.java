package com.wipro.healthcare.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.healthcare.dto.DoctorDto;
import com.wipro.healthcare.entities.Doctor;

public interface IDoctorService {

	ResponseEntity<Doctor> getDoctorById(Long doctorId);

	ResponseEntity<Doctor> registerDoctor(DoctorDto doctorDto);

	ResponseEntity<Doctor> updateDoctor(Long doctorId, DoctorDto doctorDetails);

	ResponseEntity<List<Doctor>> getAllDoctors();

	ResponseEntity<String> deleteDoctor(Long doctorId);

}
