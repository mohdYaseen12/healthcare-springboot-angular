package com.wipro.healthcare.entities;

import java.time.LocalTime;
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
@Table(name = "appointment")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment-id")
	Long appointmentId;

	@ManyToOne
	@JoinColumn(name = "patient-id")
	Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctor-id")
	Doctor doctor;

	@Column(name = "appointment-date")
	Date appointmentDate;

	@Column(name = "appointment-time")
	LocalTime appointmentTime;

	@Column(name = "symptoms")
	String symptoms;

	@Column(name = "status")
	String status;
}
