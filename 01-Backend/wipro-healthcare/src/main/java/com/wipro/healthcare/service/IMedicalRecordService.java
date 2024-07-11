package com.wipro.healthcare.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.healthcare.dto.MedicalRecordDto;
import com.wipro.healthcare.entities.MedicalRecord;

public interface IMedicalRecordService {

	ResponseEntity<MedicalRecord> saveMedicalRecord(MedicalRecordDto medicalRecordDto);

	ResponseEntity<List<MedicalRecord>> getMedicalRecordsByPatientId(Long patientId);

	ResponseEntity<List<MedicalRecord>> getMedicalRecordsByDoctorId(Long doctorId);

	ResponseEntity<MedicalRecord> updateMedicalRecord(Long recordId, MedicalRecordDto medicalRecordDto);

	ResponseEntity<String> deleteMedicalRecord(Long recordId);

	ResponseEntity<List<MedicalRecord>> getAllMedicalRecords();

}
