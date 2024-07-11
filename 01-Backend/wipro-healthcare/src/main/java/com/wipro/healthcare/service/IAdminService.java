package com.wipro.healthcare.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.healthcare.dto.AdminDto;
import com.wipro.healthcare.entities.Admin;

public interface IAdminService {

	ResponseEntity<List<Admin>> getAllAdmin();

	ResponseEntity<Admin> registerAdmin(AdminDto adminDto);

	ResponseEntity<Admin> updateAdmin(Long adminId, AdminDto adminDto);

	ResponseEntity<String> deleteAdmin(Long id);

	ResponseEntity<Admin> getAdminById(Long id);

}
