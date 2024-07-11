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

import com.wipro.healthcare.dto.AdminDto;
import com.wipro.healthcare.entities.Admin;
import com.wipro.healthcare.exception.AdminNotFoundException;
import com.wipro.healthcare.repositories.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService, UserDetailsService {

	@Autowired
	private IAdminRepository adminRepository;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with Email: " + email));
		return new User(admin.getEmail(), admin.getPassword(), new ArrayList<>());
	}

	@Override
	public ResponseEntity<List<Admin>> getAllAdmin() {
		List<Admin> admins = adminRepository.findAll();
		return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Admin> registerAdmin(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setEmail(adminDto.getEmail());
		admin.setPassword(encoder.encode(adminDto.getPassword()));
		adminRepository.save(admin);
		return ResponseEntity.ok(admin);
	}

	@Override
	public ResponseEntity<Admin> updateAdmin(Long adminId, AdminDto adminDto) {
		Admin adminUpdate = adminRepository.findById(adminId).get();
		if (adminUpdate != null) {
			if (adminDto.getEmail() != null)
				adminUpdate.setEmail(adminDto.getEmail());
			if (adminDto.getPassword() != null)
				adminUpdate.setPassword(adminDto.getPassword());
			return ResponseEntity.ok(adminRepository.save(adminUpdate));
		} else
			throw new AdminNotFoundException("Admin with Id: " + adminId + " was not Found.");
	}

	@Override
	public ResponseEntity<String> deleteAdmin(Long adminId) {
		Admin admin = adminRepository.findById(adminId).get();
		if (admin != null) {
			adminRepository.delete(admin);
			return new ResponseEntity<String>("Admin with admin id " + adminId + " deleted", HttpStatus.NO_CONTENT);
		} else
			throw new AdminNotFoundException("Admin with Id: " + adminId + " was not Found.");
	}

	@Override
	public ResponseEntity<Admin> getAdminById(Long adminId) {
		Admin admin = adminRepository.findById(adminId).get();
		if (admin != null) {
			return ResponseEntity.ok(admin);
		} else
			throw new AdminNotFoundException("Admin with Id: " + adminId + " was not Found.");
	}

}
