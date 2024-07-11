import { Component } from '@angular/core';
import { AppointmentService } from 'src/app/Services/appointment.service';

@Component({
  selector: 'app-delete-appointment',
  templateUrl: './delete-appointment.component.html',
  styleUrls: ['./delete-appointment.component.css']
})
export class DeleteAppointmentComponent {
  appointmentId!: number;

  constructor(private appointmentService: AppointmentService) {}

  onSubmit() {
    if (this.appointmentId) {
      this.appointmentService.deleteAppointment(this.appointmentId).subscribe({
        next: () => {
          this.appointmentId = 0;
        },
        error: err => {
          console.error('Error deleting appointment', err);
          alert('Appointment deleted successfully!');
        }
      });
    } else {
      alert('Please enter a valid appointment ID');
    }
  }
}
