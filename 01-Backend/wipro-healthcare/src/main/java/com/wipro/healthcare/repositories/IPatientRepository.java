package com.wipro.healthcare.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.healthcare.entities.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long>{

	Optional<Patient> findByEmail(String email);

}
