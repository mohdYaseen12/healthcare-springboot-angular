import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-update-doctor',
  templateUrl: './update-doctor.component.html',
  styleUrls: ['./update-doctor.component.css']
})
export class UpdateDoctorComponent {
  doctorId: number;
  email!: string;
  password!: string;
  firstName!: string;
  lastName!: string;
  phoneNumber!: string;
  specialty!: string;
  qualification!: string;
  experience!: string;
  designation!: string;

  constructor(private adminService: AdminService, private route: ActivatedRoute) {
    this.doctorId = this.route.snapshot.params['doctorId'];
  }

  onSubmit() {
    const doctorData = {
      email: this.email,
      password: this.password,
      firstName: this.firstName,
      lastName: this.lastName,
      phoneNumber: this.phoneNumber,
      specialty: this.specialty,
      qualification: this.qualification,
      experience: this.experience,
      designation: this.designation
    };

    this.adminService.updateDoctor(this.doctorId, doctorData).subscribe(response => {
      console.log('Doctor updated successfully', response);
    }, error => {
      console.error('Error updating doctor', error);
    });
  }
}
