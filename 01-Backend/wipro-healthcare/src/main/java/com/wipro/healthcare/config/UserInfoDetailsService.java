package com.wipro.healthcare.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.healthcare.entities.Admin;
import com.wipro.healthcare.entities.Doctor;
import com.wipro.healthcare.entities.Patient;
import com.wipro.healthcare.repositories.IAdminRepository;
import com.wipro.healthcare.repositories.IDoctorRepository;
import com.wipro.healthcare.repositories.IPatientRepository;

@Service
public class UserInfoDetailsService implements UserDetailsService {

	@Autowired
	private IPatientRepository patientRepo;

	@Autowired
	private IDoctorRepository doctorRepository;

	@Autowired
	private IAdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Patient> patient = patientRepo.findByEmail(email);
		if (patient.isPresent()) {
			System.out.println(patient.get());
			return patient.map(PatientDetails::new)
					.orElseThrow(() -> new UsernameNotFoundException("Patient not found with Email: " + email));
		}
		Optional<Admin> admin = adminRepository.findByEmail(email);
		if (admin.isPresent()) {
			System.out.println(admin.get());
			return admin.map(AdminDetails::new)
					.orElseThrow(() -> new UsernameNotFoundException("Admin not found with Email: " + email));
		}
		Optional<Doctor> doctor = doctorRepository.findByEmail(email);
		if (doctor.isPresent()) {
			System.out.println(doctor.get());
			return doctor.map(DoctorDetails::new)
					.orElseThrow(() -> new UsernameNotFoundException("Doctor not found with Email: " + email));
		}
		throw new UsernameNotFoundException("User Not found with Email: " + email);

	}
}
