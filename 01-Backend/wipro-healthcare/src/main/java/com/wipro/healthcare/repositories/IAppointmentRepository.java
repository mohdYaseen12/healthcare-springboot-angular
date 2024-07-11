package com.wipro.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.healthcare.entities.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

}
