package com.wipro.healthcare.dto;

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
public class MedicalRecordDto {

	Long recordId;
	Long patientId;
	Long doctorId;
	Date consultationDate;
	String diagnosis;
	String treatment;
	
}
