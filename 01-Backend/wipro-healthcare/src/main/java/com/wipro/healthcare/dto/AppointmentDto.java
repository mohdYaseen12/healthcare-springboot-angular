package com.wipro.healthcare.dto;

import java.time.LocalTime;
import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

	Long appointmentId;
	Long patientId;
	Long doctorId;
	Date appointmentDate;
	LocalTime appointmentTime;
	String symptoms;
	String status;

}
