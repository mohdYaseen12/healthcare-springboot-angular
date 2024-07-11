import { Component } from '@angular/core';
import { PatientService } from 'src/app/Services/patient.service';
import { Patient } from 'src/app/Models/patient';

@Component({
  selector: 'app-patient-register',
  templateUrl: './register-patient.component.html',
  styleUrls: ['./register-patient.component.css'],
})
export class PatientRegisterComponent {
  patient: Patient = {} as Patient;

  constructor(private patientService: PatientService) {}

  register() {
    this.patientService.registerPatient(this.patient).subscribe(
      (responce) => {
        console.log('Patient Registered Successfully', responce);
      },
      (error) => {
        console.log('Patient Regidtration Failed!', error);
      }
    );
  }
}
