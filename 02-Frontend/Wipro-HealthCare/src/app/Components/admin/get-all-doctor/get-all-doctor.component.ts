import { Component } from '@angular/core';
import { Doctor } from 'src/app/Models/doctor';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-get-all-doctor',
  templateUrl: './get-all-doctor.component.html',
  styleUrls: ['./get-all-doctor.component.css']
})
export class GetAllDoctorComponent {
  doctors: Doctor[] = [];
  response: string = '';

  constructor(private adminService: AdminService) {}

  ngOnInit() {
    this.adminService.getAllDoctor().subscribe(
      (data: Doctor[]) => {
        this.doctors = data;
      },error => {
        console.error('Error fetching Doctors', error);
      }
    );
  }

  deleteDoctor(doctorId: number){
    this.adminService.deleteDoctor(doctorId).subscribe(
      () => {
        this.response = 'Doctor deleted successfully.';
        this.doctors = this.doctors.filter(doctor => doctor.doctorId !== doctorId);
      },
      error => {
        this.response = 'Error deleting Doctor: ' + error.message;
      }
    );
  }

}
