package com.wipro.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.healthcare.dto.MedicalRecordDto;
import com.wipro.healthcare.entities.MedicalRecord;
import com.wipro.healthcare.service.IMedicalRecordService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

    @Autowired
    private IMedicalRecordService medicalRecordService;

    @PostMapping("/save")
    public ResponseEntity<MedicalRecord> createMedicalRecord(@RequestBody MedicalRecordDto medicalRecordDto) {
        return medicalRecordService.saveMedicalRecord(medicalRecordDto);
    }

    @GetMapping("/patientRecord/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByPatientId(@PathVariable Long patientId) {
        return medicalRecordService.getMedicalRecordsByPatientId(patientId);
    }

    @GetMapping("/doctorRecord/{doctorId}")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByDoctorId(@PathVariable Long doctorId) {
        return medicalRecordService.getMedicalRecordsByDoctorId(doctorId);
    }

    @GetMapping("/getAllMedicalRecords")
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }

    @PutMapping("/update/{recordId}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable Long recordId, @RequestBody MedicalRecordDto medicalRecordDto) {
        return medicalRecordService.updateMedicalRecord(recordId, medicalRecordDto);
    }

    @DeleteMapping("/delete/{recordId}")
    public ResponseEntity<String> deleteMedicalRecord(@PathVariable Long recordId) {
        return medicalRecordService.deleteMedicalRecord(recordId);
    }
}
