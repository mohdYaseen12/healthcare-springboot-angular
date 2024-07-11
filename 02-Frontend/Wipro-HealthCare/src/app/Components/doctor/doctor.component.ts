import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Doctor } from 'src/app/Models/doctor';
import { DoctorService } from 'src/app/Services/doctor.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css'],
})
export class DoctorComponent implements OnInit {
  doctor!: Doctor;
  appointments: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private doctorService: DoctorService
  ) {}

  ngOnInit(): void {
    const doctorId = Number(this.route.snapshot.paramMap.get('id'));
    this.getDoctorById(doctorId);
    this.getAppointments(doctorId);
  }

  getDoctorById(id: number): void {
    this.doctorService.getDoctorById(id).subscribe(
      (data) => (this.doctor = data),
      (error) => console.error(error)
    );
  }

  getAppointments(doctorId: number): void {
    this.doctorService.getAppointments(doctorId).subscribe(
      (data) => (this.appointments = data),
      (error) => console.error(error)
    );
  }
}
