package com.wipro.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.healthcare.entities.Consultation;

@Repository
public interface IConsultationRepository extends JpaRepository<Consultation, Long>{

}
