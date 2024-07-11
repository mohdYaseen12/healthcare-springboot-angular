package com.wipro.healthcare.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.healthcare.dto.AppointmentDto;
import com.wipro.healthcare.entities.Appointment;

public interface IAppointmentService {

	ResponseEntity<AppointmentDto> viewAppointmentStatus(Long appointmentId);

	ResponseEntity<Appointment> getAppointmentById(Long appointmentId);

	ResponseEntity<Appointment> bookAppointment(AppointmentDto appointmentDto);

	ResponseEntity<Appointment> updateAppointment(Long appointmentId, AppointmentDto appointmentDto);

	ResponseEntity<List<Appointment>> getAllAppointments();

	ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(Long doctorId);

	ResponseEntity<List<Appointment>> getUpcomingAppointmentsByDoctorId(Long doctorId);

	ResponseEntity<String> cancelAppointment(Long appointmentId);	

}
