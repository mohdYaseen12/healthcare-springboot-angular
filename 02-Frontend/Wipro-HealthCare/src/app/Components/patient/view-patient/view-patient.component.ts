import { Component } from '@angular/core';
import { Patient } from 'src/app/Models/patient';
import { PatientService } from 'src/app/Services/patient.service';

@Component({
  selector: 'app-view-patient',
  templateUrl: './view-patient.component.html',
  styleUrls: ['./view-patient.component.css'],
})
export class ViewPatientComponent {
  patientId!: number;
  patient?: Patient;

  constructor(private patientService: PatientService) {}

  getPatient() {
    this.patientService.viewPatient(this.patientId).subscribe(
      (data: Patient) => {
        this.patient = data;
      },
      (error) => {
        console.error('Error fetching Doctor', error);
      }
    );
  }
}
