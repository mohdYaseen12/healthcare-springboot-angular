package com.wipro.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.healthcare.dto.ConsultationDto;
import com.wipro.healthcare.entities.Appointment;
import com.wipro.healthcare.entities.Consultation;
import com.wipro.healthcare.exception.AppointmentNotFoundException;
import com.wipro.healthcare.exception.ConsultationNotFoundException;
import com.wipro.healthcare.repositories.IAppointmentRepository;
import com.wipro.healthcare.repositories.IConsultationRepository;

@Service
public class ConsultationServiceImpl implements IConsultationService {

	@Autowired
	private IConsultationRepository consultationRepository;

	@Autowired
	private IAppointmentRepository appointmentRepository;

	@Override
	public ResponseEntity<Consultation> conductConsultation(Long appointmentId, ConsultationDto consultationDto) {
		Consultation consultation = new Consultation();
		consultation.setCurrentSymptoms(consultationDto.getCurrentSymptoms());
		consultation.setPhysicalExamination(consultationDto.getPhysicalExamination());
		consultation.setPrescription(consultationDto.getPrescription());
		consultation.setRecommendedTests(consultationDto.getRecommendedTests());
		consultation.setTreatmentPlan(consultationDto.getTreatmentPlan());
		Appointment appointment = appointmentRepository.findById(appointmentId).get();
		if (appointment != null) {
			consultation.setAppointment(appointment);
		} else
			throw new AppointmentNotFoundException("Appointment with Id: " + appointmentId + " was not found.");
		Consultation savedConsultation = consultationRepository.save(consultation);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedConsultation);
	}

	@Override
	public ResponseEntity<Consultation> updateConsultation(Long consultationId, ConsultationDto consultationDetails) {
		Consultation consultation = consultationRepository.findById(consultationId).get();
		if (consultation != null) {
			if (consultationDetails.getCurrentSymptoms() != null)
				consultation.setCurrentSymptoms(consultationDetails.getCurrentSymptoms());
			if (consultationDetails.getPhysicalExamination() != null)
				consultation.setPhysicalExamination(consultationDetails.getPhysicalExamination());
			if (consultationDetails.getTreatmentPlan() != null)
				consultation.setTreatmentPlan(consultationDetails.getTreatmentPlan());
			if (consultationDetails.getRecommendedTests() != null)
				consultation.setRecommendedTests(consultationDetails.getRecommendedTests());
			if (consultationDetails.getPrescription() != null)
				consultation.setPrescription(consultationDetails.getPrescription());
			if (consultationDetails.getAppointmentId() != 0) {
				Appointment appointment = appointmentRepository.findById(consultationDetails.getAppointmentId()).get();
				consultation.setAppointment(appointment);
			} else
				throw new AppointmentNotFoundException(
						"Appointment with Id: " + consultationDetails.getAppointmentId() + " was not found.");
			Consultation updatedConsultation = consultationRepository.save(consultation);
			return ResponseEntity.ok(updatedConsultation);
		} else
			throw new ConsultationNotFoundException("Consultation with Id: " + consultationId + " was not found.");
	}

	@Override
	public ResponseEntity<String> deleteConsultation(Long consultationId) {
		Consultation consultation = consultationRepository.findById(consultationId).get();
		if (consultation != null) {
			consultationRepository.delete(consultation);
			String response = "Consultation Deleted Successfully";
			return new ResponseEntity<String>(response, HttpStatus.NO_CONTENT);
		} else
			throw new ConsultationNotFoundException("Consultation with Id: " + consultationId + " was not found.");
	}

	@Override
	public ResponseEntity<Consultation> getConsultationById(Long consultationId) {
		Consultation consultation = consultationRepository.findById(consultationId).get();
		if (consultation != null) {
			return ResponseEntity.ok(consultation);
		} else
			throw new ConsultationNotFoundException("Consultation with Id: " + consultationId + " was not found.");
	}

	@Override
	public ResponseEntity<List<Consultation>> getAllConsultations() {
		List<Consultation> consultations = consultationRepository.findAll();
		if (!consultations.isEmpty()) {
			return ResponseEntity.ok(consultations);
		} else
			throw new ConsultationNotFoundException("Consultation List is Empty.");
	}
}
