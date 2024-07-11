package com.wipro.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.healthcare.dto.AppointmentDto;
import com.wipro.healthcare.entities.Appointment;
import com.wipro.healthcare.service.IAppointmentService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping("/bookAppointment")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody AppointmentDto appointmentDto) {
    	ResponseEntity<Appointment> bookedAppointment = appointmentService.bookAppointment(appointmentDto);
        return bookedAppointment;
    }

    @PutMapping("/update/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long appointmentId, @RequestBody AppointmentDto appointmentDto) {
    	ResponseEntity<Appointment> updatedAppointment = appointmentService.updateAppointment(appointmentId, appointmentDto);
        if (updatedAppointment != null) {
            return updatedAppointment;
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAppointmentById/{appointmentId}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long appointmentId) {
    	ResponseEntity<Appointment> appointment = appointmentService.getAppointmentById(appointmentId);
        if (appointment != null) {
            return appointment;
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long appointmentId) {
    	ResponseEntity<String> response = appointmentService.cancelAppointment(appointmentId);
        if (response.equals("Appointment deleted successfully.")) {
            return response;
        }
        return ResponseEntity.notFound().build();
    }
}
