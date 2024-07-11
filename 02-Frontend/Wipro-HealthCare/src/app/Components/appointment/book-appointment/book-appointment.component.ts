import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Appointment } from 'src/app/Models/appointment';
import { AppointmentService } from 'src/app/Services/appointment.service';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent {

  appointmentForm: FormGroup;

  constructor(private fb: FormBuilder, private appointmentService: AppointmentService) {
    this.appointmentForm = this.fb.group({
      patientId: '',
      doctorId: '',
      appointmentDate: '',
      appointmentTime: '',
      symptoms: '',
      status: ''
    });
  }

  onSubmit() {
    if (this.appointmentForm.valid) {
      const appointment: Appointment = this.appointmentForm.value;
      this.appointmentService.bookAppointment(appointment).subscribe({
        next: response => {
          alert('Appointment booked successfully!');
          this.appointmentForm.reset();
        },
        error: err => {
          console.error('Error booking appointment', err);
          alert('Failed to book appointment');
        }
      });
    }
  }
}
