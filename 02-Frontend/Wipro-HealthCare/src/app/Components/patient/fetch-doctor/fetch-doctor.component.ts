import { Component } from '@angular/core';
import { Doctor } from 'src/app/Models/doctor';
import { PatientService } from 'src/app/Services/patient.service';

@Component({
  selector: 'app-fetch-doctor',
  templateUrl: './fetch-doctor.component.html',
  styleUrls: ['./fetch-doctor.component.css'],
})
export class FetchDoctorComponent {
  doctorId!: number;
  doctor?: Doctor;

  constructor(private patientService: PatientService) {}

  getDoctor() {
    this.patientService.fetchDoctor(this.doctorId).subscribe(
      (data: Doctor) => {
        this.doctor = data;
      },
      error => {
        console.error('Error fetching Doctor', error);
      }
    );
  }
}
