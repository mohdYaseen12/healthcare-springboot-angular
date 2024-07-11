package com.wipro.healthcare.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.healthcare.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {
	Optional<Admin> findByEmail(String email);
}
