import { Component } from '@angular/core';
import { Patient } from 'src/app/Models/patient';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-get-all-patient',
  templateUrl: './get-all-patient.component.html',
  styleUrls: ['./get-all-patient.component.css'],
})
export class GetAllPatientComponent {
  patients: Patient[] = [];
  response: string = '';

  constructor(private adminService: AdminService) {}

  ngOnInit() {
    this.adminService.getAllPatient().subscribe(
      (data: Patient[]) => {
        this.patients = data;
      },
      (error) => {
        console.error('Error fetching Patients', error);
      }
    );
  }

  deletePatient(patientId: number) {
    this.adminService.deletePatient(patientId).subscribe(
      () => {
        this.response = 'Doctor deleted successfully.';
        this.patients = this.patients.filter(
          (patient) => patient.patientId !== patientId
        );
      },
      (error) => {
        this.response = 'Error deleting Doctor: ' + error.message;
      }
    );
  }
}
