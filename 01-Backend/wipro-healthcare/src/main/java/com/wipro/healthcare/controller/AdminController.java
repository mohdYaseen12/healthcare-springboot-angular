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

import com.wipro.healthcare.dto.AdminDto;
import com.wipro.healthcare.dto.AuthRequest;
import com.wipro.healthcare.dto.DoctorDto;
import com.wipro.healthcare.dto.PatientDto;
import com.wipro.healthcare.entities.Admin;
import com.wipro.healthcare.entities.Doctor;
import com.wipro.healthcare.entities.MedicalRecord;
import com.wipro.healthcare.entities.Patient;
import com.wipro.healthcare.service.AuthJwtService;
import com.wipro.healthcare.service.IAdminService;
import com.wipro.healthcare.service.IDoctorService;
import com.wipro.healthcare.service.IMedicalRecordService;
import com.wipro.healthcare.service.IPatientService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private AuthJwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IPatientService patientService;

	@Autowired
	private IMedicalRecordService medicalRecordService;

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
	public ResponseEntity<Admin> registerAdmin(@RequestBody AdminDto adminDto) {
		return adminService.registerAdmin(adminDto);
	}

	@PutMapping("/update/{adminId}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long adminId, @RequestBody AdminDto adminDto) {
		return adminService.updateAdmin(adminId, adminDto);
	}

	@PostMapping("/saveDoctor")
	public ResponseEntity<Doctor> registerDoctor(@RequestBody DoctorDto doctorDto) {
		return doctorService.registerDoctor(doctorDto);
	}

	@PutMapping("/updateDoctor")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDto doctorDto) {
		return doctorService.updateDoctor(doctorId, doctorDto);
	}

	@GetMapping("/getAllDoctor")
	public ResponseEntity<List<Doctor>> getAllDoctor() {
		return doctorService.getAllDoctors();
	}

	@DeleteMapping("/deleteDoctor/{doctorId}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Long doctorId) {
		return doctorService.deleteDoctor(doctorId);
	}

	@GetMapping("/getDoctor/{doctorId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long doctorId) {
		return doctorService.getDoctorById(doctorId);
	}

	@GetMapping("/getPatient/{patientId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
		return patientService.getPatientById(patientId);
	}

	@GetMapping("/getAllPatient")
	public ResponseEntity<List<Patient>> getAllPatient() {
		return patientService.getAllPatients();
	}

	@PutMapping("/updatePatient/{patientId}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId, @RequestBody PatientDto patientDto) {
		return patientService.updatePatient(patientId, patientDto);
	}

	@DeleteMapping("/deletePatient/{patientId}")
	public ResponseEntity<String> deletePatientById(@PathVariable Long patientId) {
		return patientService.deletePatientById(patientId);
	}

	@GetMapping("/getRecord/{patientId}")
	public ResponseEntity<List<MedicalRecord>> getMedicalRecords(@PathVariable Long patientId) {
		return medicalRecordService.getMedicalRecordsByPatientId(patientId);
	}
}
