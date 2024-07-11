import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/Models/doctor';
import { DoctorService } from 'src/app/Services/doctor.service';

@Component({
  selector: 'app-register-doctor',
  templateUrl: './register-doctor.component.html',
  styleUrls: ['./register-doctor.component.css']
})
export class DoctorRegistrationComponent {
  doctor: Doctor = {
    doctorId: 0,
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    designation: '',
    phoneNumber: '',
    specialty: '',
    experience: 0,
    qualification: ''
  };

  constructor(private doctorService: DoctorService, private router: Router) {}

  registerDoctor(): void {
    this.doctorService.registerDoctor(this.doctor).subscribe(
      response => {
        console.log('Doctor registered successfully!', response);
        this.router.navigate(['/view-doctor']);
      },
      error => {
        console.error('Error registering doctor!', error);
      }
    );
  }
}
