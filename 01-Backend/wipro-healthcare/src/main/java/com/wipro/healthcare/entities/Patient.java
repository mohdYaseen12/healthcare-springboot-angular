package com.wipro.healthcare.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "patient")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	
	private final String role = "PATIENT";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient-id")
	Long patientId;

	@Column(name = "first-name")
	String firstName;

	@Column(name = "last-name")
	String lastName;

	@Column(name = "gender")
	String gender;

	@Column(name = "email", unique = true)
	String email;

	@Column(name = "password")
	String password;

	@Column(name = "phone-number")
	String phoneNumber;

	@Column(name = "dob")
	Date dateOfBirth;

	@Column(name = "address")
	String address;

	@OneToMany(mappedBy = "patient")
	@JsonIgnore
	List<Appointment> appointment;

	@OneToMany(mappedBy = "patient")
	@JsonIgnore
	List<MedicalRecord> medicalRecords;
}
