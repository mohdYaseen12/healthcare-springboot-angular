package com.wipro.healthcare.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDto {

	Long consultingId;
	String currentSymptoms;
	String physicalExamination;
	String treatmentPlan;
	String recommendedTests;
	String prescription;
	Long appointmentId;

}
