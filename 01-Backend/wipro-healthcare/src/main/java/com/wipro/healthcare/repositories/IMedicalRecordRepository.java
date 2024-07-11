package com.wipro.healthcare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.healthcare.entities.MedicalRecord;

@Repository
public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

	@Query("SELECT m FROM MedicalRecord m WHERE m.patient.patientId = :patientId")
	List<MedicalRecord> findByPatientId(@Param("patientId") Long patientId);

	@Query("SELECT m FROM MedicalRecord m WHERE m.doctor.doctorId = :doctorId")
	List<MedicalRecord> findByDoctorId(@Param("doctorId") Long doctorId);

}
