import { Component } from '@angular/core';
import { Doctor } from 'src/app/Models/doctor';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-get-doctor',
  templateUrl: './get-doctor.component.html',
  styleUrls: ['./get-doctor.component.css']
})
export class GetDoctorComponent {
  doctorId!: number;
  doctor?: Doctor;

  constructor(private adminService: AdminService){}

  getDoctor(){
    this.adminService.getDoctor(this.doctorId).subscribe(
      (data: Doctor) => {
        this.doctor = data;
      },
      (error) => {
        console.error('Error fetching Doctor', error);
      }
    );
  }
}
