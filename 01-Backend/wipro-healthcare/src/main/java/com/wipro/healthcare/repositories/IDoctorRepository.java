package com.wipro.healthcare.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.healthcare.entities.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long>{
	Optional<Doctor> findByEmail(String email);
}
