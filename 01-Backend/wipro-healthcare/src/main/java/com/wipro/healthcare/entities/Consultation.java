package com.wipro.healthcare.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "consultation")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consulting-id")
	Long consultingId;
	
	@Column(name = "current-symptoms")
	String currentSymptoms;
	
	@Column(name = "physical-examination")
	String physicalExamination;
	
	@Column(name = "treatment-plan")
	String treatmentPlan;
	
	@Column(name = "recommended-tests")
	String recommendedTests;
	
	@Column(name = "prescription")
	String prescription;
	
	@OneToOne
    @JoinColumn(name = "appointment_id")
    Appointment appointment;
	
}
