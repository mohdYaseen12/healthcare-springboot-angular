package com.wipro.healthcare.entities;

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
@Table(name = "doctor")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	
	private final String role = "DOCTOR";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor-id")
	Long doctorId;

	@Column(name = "first-name")
	String firstName;

	@Column(name = "last-name")
	String lastName;

	@Column(name = "email", unique = true)
	String email;

	@Column(name = "password")
	String password;
	
	@Column(name = "designation")
	String designation;

	@Column(name = "phone-number")
	String phoneNumber;

	@Column(name = "specialty")
	String specialty;

	@Column(name = "experience")
	int experience;

	@Column(name = "qualification")
	String qualification;

	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	List<Appointment> appointments;

	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	List<MedicalRecord> medicalRecords;
}
