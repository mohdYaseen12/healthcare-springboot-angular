package com.wipro.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.healthcare.dto.AppointmentDto;
import com.wipro.healthcare.dto.AuthRequest;
import com.wipro.healthcare.dto.PatientDto;
import com.wipro.healthcare.entities.Doctor;
import com.wipro.healthcare.entities.Patient;
import com.wipro.healthcare.service.AuthJwtService;
import com.wipro.healthcare.service.IAppointmentService;
import com.wipro.healthcare.service.IDoctorService;
import com.wipro.healthcare.service.IPatientService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private AuthJwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IPatientService patientService;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IAppointmentService appointmentService;
	
	@PostMapping("/authenticate")
	public String authenticateAndGetTokent(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		String token = null;
		if (authentication.isAuthenticated()) {
			token = jwtService.generateToken(authRequest.getEmail());
		} else {
			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");
		}
		return "Token: " + token;
	}

	@PostMapping("/save")
	public ResponseEntity<Patient> registerPatient(@RequestBody PatientDto patientDto) {
		return patientService.registerPatient(patientDto);
	}

	@PutMapping("/updatePatient/{patientId}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId, @RequestBody PatientDto patientDto) {
		return patientService.updatePatient(patientId, patientDto);
	}

	@GetMapping("/viewPatient/{patientId}")
	public ResponseEntity<Patient> viewPatient(@PathVariable Long patientId) {
		return patientService.getPatientById(patientId);
	}

	@GetMapping("/fetchDoctor/{doctorId}")
	public ResponseEntity<Doctor> fetchDoctor(@PathVariable Long doctorId) {
		return doctorService.getDoctorById(doctorId);
	}

	@GetMapping("/appointmentStatus/{appointmentId}")
	public ResponseEntity<AppointmentDto> viewAppointmentStatus(@PathVariable Long appointmentId) {
		return appointmentService.viewAppointmentStatus(appointmentId);
	}
}
