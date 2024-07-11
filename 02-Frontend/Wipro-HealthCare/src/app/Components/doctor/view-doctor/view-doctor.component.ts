import { Component } from '@angular/core';
import { DoctorService } from 'src/app/Services/doctor.service';

@Component({
  selector: 'app-view-doctor',
  templateUrl: './view-doctor.component.html',
  styleUrls: ['./view-doctor.component.css']
})
export class ViewDoctorComponent {
  doctorId!: number;
  doctor: any;

  constructor(private doctorService: DoctorService) {}

  getDoctor() {
    this.doctorService.getDoctorById(this.doctorId).subscribe(response => {
      this.doctor = response;
    });
  }
}
