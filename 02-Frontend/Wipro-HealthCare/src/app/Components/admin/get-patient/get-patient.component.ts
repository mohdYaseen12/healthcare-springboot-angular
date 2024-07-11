import { Component } from '@angular/core';
import { Patient } from 'src/app/Models/patient';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-get-patient',
  templateUrl: './get-patient.component.html',
  styleUrls: ['./get-patient.component.css']
})
export class GetPatientComponent {
  patientId!: number;
  patient?: Patient;

  constructor(private adminService: AdminService){}

  getPatient(){
    this.adminService.getPatient(this.patientId).subscribe(
      (data: Patient) => {
        this.patient = data;
      },
      (error) => {
        console.error('Error fetching Doctor', error);
      }
    );
  }
}
