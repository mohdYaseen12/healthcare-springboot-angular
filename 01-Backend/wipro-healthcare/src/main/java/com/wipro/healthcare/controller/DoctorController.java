package com.wipro.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.healthcare.dto.AuthRequest;
import com.wipro.healthcare.dto.ConsultationDto;
import com.wipro.healthcare.dto.MedicalRecordDto;
import com.wipro.healthcare.entities.Appointment;
import com.wipro.healthcare.entities.Consultation;
import com.wipro.healthcare.entities.Doctor;
import com.wipro.healthcare.entities.MedicalRecord;
import com.wipro.healthcare.service.AuthJwtService;
import com.wipro.healthcare.service.IAppointmentService;
import com.wipro.healthcare.service.IConsultationService;
import com.wipro.healthcare.service.IDoctorService;
import com.wipro.healthcare.service.IMedicalRecordService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private AuthJwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IAppointmentService appointmentService;

	@Autowired
	private IMedicalRecordService medicalRecordService;

	@Autowired
	private IConsultationService consultationService;
	
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

	@GetMapping("/viewDoctor/{doctorId}")
	public ResponseEntity<Doctor> viewDoctor(@PathVariable Long doctorId) {
		return doctorService.getDoctorById(doctorId);
	}

	@GetMapping("/viewAppointments/{doctorId}")
	public ResponseEntity<List<Appointment>> viewAllAppointments(@PathVariable Long doctorId) {
		return appointmentService.getAppointmentsByDoctorId(doctorId);
	}

	@GetMapping("/upcomingAppointments/{doctorId}")
	public ResponseEntity<List<Appointment>> upcomingAppointments(@PathVariable Long doctorId) {
		return appointmentService.getUpcomingAppointmentsByDoctorId(doctorId);
	}

	@PutMapping("/conductConsultation/{appointmentId}")
	public ResponseEntity<Consultation> conductConsultation(@PathVariable Long appointmentId,
			@RequestBody ConsultationDto consultationDto) {
		return consultationService.conductConsultation(appointmentId, consultationDto);
	}

	@PutMapping("/medicalRecord/{patientId}")
	public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable Long patientId,
			@RequestBody MedicalRecordDto medicalRecordDto) {
		return medicalRecordService.updateMedicalRecord(patientId, medicalRecordDto);
	}

	@PutMapping("/updateConsultation/{consultationId}")
	public ResponseEntity<Consultation> updateConsultation(@PathVariable Long consultationId,
			@RequestBody ConsultationDto consultationDto) {
		return consultationService.updateConsultation(consultationId, consultationDto);
	}

	@DeleteMapping("/deleteConsultation/{consultationId}")
	public ResponseEntity<String> deleteConsultation(@PathVariable Long consultationId) {
		return consultationService.deleteConsultation(consultationId);
	}

	@GetMapping("/getConsultation/{consultationId}")
	public ResponseEntity<Consultation> getConsultationById(@PathVariable Long consultationId) {
		return consultationService.getConsultationById(consultationId);
	}

	@GetMapping("/getAllConsultations")
	public ResponseEntity<List<Consultation>> getAllConsultations() {
		return consultationService.getAllConsultations();
	}
}
