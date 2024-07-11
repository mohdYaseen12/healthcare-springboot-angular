import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from 'src/app/Services/patient.service';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css'],
})
export class UpdatePatientComponent {
  patientId: number;
  firstName!: string;
  lastName!: string;
  email!: string;
  phoneNumber!: string;
  dateOfBirth!: Date;
  address!: string;

  constructor(private patientService: PatientService, private route: ActivatedRoute) {
    this.patientId = this.route.snapshot.params['doctorId'];
  }
  onSubmit() {
    const patientData = {
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.email,
      phoneNumber: this.phoneNumber,
      dateOfBirth: this.dateOfBirth,
      address: this.address,
    };

    this.patientService.updatePatient(this.patientId, patientData).subscribe(response => {
      console.log('Doctor updated successfully', response);
    }, error => {
      console.error('Error updating doctor', error);
    });
  }
}
