package com.wipro.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.healthcare.dto.AppointmentDto;
import com.wipro.healthcare.entities.Appointment;
import com.wipro.healthcare.entities.Doctor;
import com.wipro.healthcare.entities.Patient;
import com.wipro.healthcare.exception.AppointmentNotFoundException;
import com.wipro.healthcare.exception.DoctorNotFoundException;
import com.wipro.healthcare.exception.PatientNotFoundException;
import com.wipro.healthcare.repositories.IAppointmentRepository;
import com.wipro.healthcare.repositories.IDoctorRepository;
import com.wipro.healthcare.repositories.IPatientRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private IAppointmentRepository appointmentRepository;

	@Autowired
	private IDoctorRepository doctorRepository;

	@Autowired
	private IPatientRepository patientRepository;

	@Override
	public ResponseEntity<AppointmentDto> viewAppointmentStatus(Long appointmentId) {
		Appointment appointment = appointmentRepository.findById(appointmentId).get();
		if (appointment != null) {
			AppointmentDto dto = new AppointmentDto();
			dto.setAppointmentId(appointment.getAppointmentId());
			dto.setPatientId(appointment.getPatient().getPatientId());
			dto.setDoctorId(appointment.getDoctor().getDoctorId());
			dto.setAppointmentDate(appointment.getAppointmentDate());
			dto.setAppointmentTime(appointment.getAppointmentTime());
			dto.setSymptoms(appointment.getSymptoms());
			dto.setStatus(appointment.getStatus());
			return new ResponseEntity<AppointmentDto>(dto, HttpStatus.OK);
		} else
			throw new AppointmentNotFoundException("Appointment with Id: " + appointmentId + " was not found.");
	}

	@Override
	public ResponseEntity<Appointment> getAppointmentById(Long appointmentId) {
		Appointment appointment = appointmentRepository.findById(appointmentId).get();
		if (appointment != null) {
			return ResponseEntity.ok(appointment);
		} else
			throw new AppointmentNotFoundException("Appointment with Id: " + appointmentId + " was not found.");
	}

	@Override
	public ResponseEntity<Appointment> bookAppointment(AppointmentDto appointmentDto) {
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
		appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
		Doctor doctor = doctorRepository.findById(appointmentDto.getDoctorId()).get();
		if (doctor != null) {
			appointment.setDoctor(doctor);
		} else
			throw new DoctorNotFoundException("Doctor with Id: " + appointmentDto.getDoctorId() + " was not found.");
		Patient patient = patientRepository.findById(appointmentDto.getPatientId()).get();
		if (patient != null) {
			appointment.setPatient(patient);
		} else
			throw new PatientNotFoundException("Patient with Id: " + appointmentDto.getPatientId() + " was not found.");
		appointment.setStatus(appointmentDto.getStatus());
		appointment.setSymptoms(appointmentDto.getSymptoms());
		Appointment savedAppointment = appointmentRepository.save(appointment);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
	}

	@Override
	public ResponseEntity<Appointment> updateAppointment(Long appointmentId, AppointmentDto appointmentDetails) {
		Appointment appointment = appointmentRepository.findById(appointmentId).get();
		if (appointment != null) {
			if (appointmentDetails.getAppointmentDate() != null)
				appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
			if (appointmentDetails.getAppointmentTime() != null)
				appointment.setAppointmentTime(appointmentDetails.getAppointmentTime());
			if (appointmentDetails.getAppointmentTime() != null)
				appointment.setSymptoms(appointmentDetails.getSymptoms());
			if (appointmentDetails.getStatus() != null)
				appointment.setStatus(appointmentDetails.getStatus());
			if (appointmentDetails.getDoctorId() != null) {
				Doctor doctor = doctorRepository.findById(appointmentDetails.getDoctorId()).get();
				if (doctor != null)
					appointment.setDoctor(doctor);
				else
					throw new DoctorNotFoundException(
							"Doctor with Id: " + appointmentDetails.getDoctorId() + " was not found.");
			}
			if (appointmentDetails.getPatientId() != null) {
				Patient patient = patientRepository.findById(appointmentDetails.getPatientId()).get();
				if (patient != null) {
					appointment.setPatient(patient);
				} else
					throw new PatientNotFoundException(
							"Patient with Id: " + appointmentDetails.getPatientId() + " was not found.");
			}
			Appointment updatedAppointment = appointmentRepository.save(appointment);
			return ResponseEntity.ok(updatedAppointment);
		} else
			throw new AppointmentNotFoundException("Appointment with Id: " + appointmentId + " was not found.");
	}

	@Override
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		List<Appointment> appointments = appointmentRepository.findAll();
		if (!appointments.isEmpty()) {
			return ResponseEntity.ok(appointments);
		} else
			throw new AppointmentNotFoundException("Appointment List is Empty.");
	}

	@Override
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(Long doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).get();
		if (doctor != null) {
			List<Appointment> appointments = doctor.getAppointments();
			return ResponseEntity.ok(appointments);
		} else
			throw new DoctorNotFoundException("Doctor with Id: " + doctorId + " was not found.");
	}

	@Override
	public ResponseEntity<List<Appointment>> getUpcomingAppointmentsByDoctorId(Long doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).get();
		if (doctor != null) {
			List<Appointment> appointments = doctor.getAppointments().stream()
					.filter(appointment -> "available".equalsIgnoreCase(appointment.getStatus())).toList();
			return ResponseEntity.ok(appointments);
		} else
			throw new DoctorNotFoundException("Doctor with Id: " + doctorId + " was not found.");
	}

	@Override
	public ResponseEntity<String> cancelAppointment(Long appointmentId) {
		Appointment appointment = appointmentRepository.findById(appointmentId).get();
		if (appointment != null) {
			appointmentRepository.deleteById(appointmentId);
			return new ResponseEntity<String>("Appointment with Id: " + appointmentId + " Canceled",
					HttpStatus.NO_CONTENT);
		} else
			throw new AppointmentNotFoundException("Appointment with Id: " + appointmentId + " was not found.");
	}

}
