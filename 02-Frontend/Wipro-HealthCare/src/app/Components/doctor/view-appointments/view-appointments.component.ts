import { Component } from '@angular/core';
import { DoctorService } from 'src/app/Services/doctor.service';

@Component({
  selector: 'app-view-appointments',
  templateUrl: './view-appointments.component.html',
  styleUrls: ['./view-appointments.component.css'],
})
export class ViewAppointmentsComponent {
  doctorId: number = 0;
  appointments: any;

  constructor(private doctorService: DoctorService) {}

  getAppointments() {
    this.doctorService.getAppointments(this.doctorId).subscribe((response) => {
      this.appointments = response;
    });
  }
}
