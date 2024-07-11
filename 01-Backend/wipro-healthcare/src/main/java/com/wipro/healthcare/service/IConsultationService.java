package com.wipro.healthcare.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.healthcare.dto.ConsultationDto;
import com.wipro.healthcare.entities.Consultation;

public interface IConsultationService {

	ResponseEntity<Consultation> conductConsultation(Long appointmentId, ConsultationDto consultationDto);

	ResponseEntity<Consultation> updateConsultation(Long consultationId, ConsultationDto consultationDetails);

	ResponseEntity<String> deleteConsultation(Long consultationId);

	ResponseEntity<Consultation> getConsultationById(Long consultationId);

	ResponseEntity<List<Consultation>> getAllConsultations();

}
