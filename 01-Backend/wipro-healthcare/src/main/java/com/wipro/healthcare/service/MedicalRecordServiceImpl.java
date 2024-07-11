package com.wipro.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.healthcare.dto.MedicalRecordDto;
import com.wipro.healthcare.entities.Doctor;
import com.wipro.healthcare.entities.MedicalRecord;
import com.wipro.healthcare.entities.Patient;
import com.wipro.healthcare.exception.DoctorNotFoundException;
import com.wipro.healthcare.exception.MedicalRecordNotFoundException;
import com.wipro.healthcare.exception.PatientNotFoundException;
import com.wipro.healthcare.repositories.IDoctorRepository;
import com.wipro.healthcare.repositories.IMedicalRecordRepository;
import com.wipro.healthcare.repositories.IPatientRepository;

@Service
public class MedicalRecordServiceImpl implements IMedicalRecordService {

	@Autowired
	private IMedicalRecordRepository medicalRecordRepository;

	@Autowired
	private IDoctorRepository doctorRepository;

	@Autowired
	private IPatientRepository patientRepository;

	@Override
	public ResponseEntity<MedicalRecord> saveMedicalRecord(MedicalRecordDto medicalRecordDto) {
		MedicalRecord record = new MedicalRecord();
		record.setConsultationDate(medicalRecordDto.getConsultationDate());
		record.setDiagnosis(medicalRecordDto.getDiagnosis());
		Doctor doctor = doctorRepository.findById(medicalRecordDto.getDoctorId()).get();
		if (doctor != null) {
			record.setDoctor(doctor);
		} else
			throw new DoctorNotFoundException("Doctor with Id: " + medicalRecordDto.getDoctorId() + " was not found.");
		Patient patient = patientRepository.findById(medicalRecordDto.getPatientId()).get();
		if (patient != null) {
			record.setPatient(patient);
		} else
			throw new PatientNotFoundException(
					"Patient with Id: " + medicalRecordDto.getPatientId() + " was not Found.");
		record.setTreatment(medicalRecordDto.getTreatment());
		MedicalRecord savedRecord = medicalRecordRepository.save(record);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
	}

	@Override
	public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByPatientId(Long patientId) {
		List<MedicalRecord> records = medicalRecordRepository.findByPatientId(patientId);
		if (!records.isEmpty()) {
			return ResponseEntity.ok(records);
		} else {
			throw new MedicalRecordNotFoundException("No medical records found for patient with ID: " + patientId);
		}
	}

	@Override
	public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByDoctorId(Long doctorId) {
		List<MedicalRecord> records = medicalRecordRepository.findByDoctorId(doctorId);
		if (!records.isEmpty()) {
			return ResponseEntity.ok(records);
		} else {
			throw new MedicalRecordNotFoundException("No medical records found for doctor with ID: " + doctorId);
		}
	}

	@Override
	public ResponseEntity<MedicalRecord> updateMedicalRecord(Long recordId, MedicalRecordDto medicalRecordDto) {
		MedicalRecord record = medicalRecordRepository.findById(recordId).get();
		if (record != null) {
			Patient patient = patientRepository.findById(medicalRecordDto.getPatientId()).get();
			if (patient != null) {
				record.setPatient(patient);
			} else
				throw new PatientNotFoundException(
						"Patient with Id: " + medicalRecordDto.getPatientId() + " was not found.");
			Doctor doctor = doctorRepository.findById(medicalRecordDto.getDoctorId()).get();
			if (doctor != null) {
				record.setDoctor(doctor);
			} else
				throw new DoctorNotFoundException(
						"Doctor with Id: " + medicalRecordDto.getDoctorId() + " was not found.");
			if (medicalRecordDto.getConsultationDate() != null)
				record.setConsultationDate(medicalRecordDto.getConsultationDate());
			if (medicalRecordDto.getDiagnosis() != null)
				record.setDiagnosis(medicalRecordDto.getDiagnosis());
			if (medicalRecordDto.getTreatment() != null)
				record.setTreatment(medicalRecordDto.getTreatment());
			MedicalRecord updatedRecord = medicalRecordRepository.save(record);
			return ResponseEntity.ok(updatedRecord);
		} else
			throw new MedicalRecordNotFoundException("Medical Record with ID: " + recordId + " was not found.");

	}

	@Override
	public ResponseEntity<String> deleteMedicalRecord(Long recordId) {
		Optional<MedicalRecord> optionalRecord = medicalRecordRepository.findById(recordId);
		if (optionalRecord.isPresent()) {
			medicalRecordRepository.delete(optionalRecord.get());
			return new ResponseEntity<String>("Medical Record with Id: " + recordId + " Deleted Successfully",
					HttpStatus.NO_CONTENT);
		} else
			throw new MedicalRecordNotFoundException("Medical Record with ID: " + recordId + " was not found.");
	}

	@Override
	public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {
		List<MedicalRecord> records = medicalRecordRepository.findAll();
		if (!records.isEmpty()) {
			return ResponseEntity.ok(records);
		} else {
			throw new MedicalRecordNotFoundException("Medical Record list is empty.");
		}
	}

}
