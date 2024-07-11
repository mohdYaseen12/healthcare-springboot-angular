package com.wipro.healthcare.entities;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "medical-record")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "record-id")
	Long recordId;

	@ManyToOne
	@JoinColumn(name = "patient-id")
	Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctor-id")
	Doctor doctor;

	@Column(name = "consultation-date")
	Date consultationDate;

	@Column(name = "diagnosis")
	String diagnosis;

	@Column(name = "treatment")
	String treatment;
}
