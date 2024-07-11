import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../Models/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private baseUrl = `http://localhost:8080/appointment`;

  constructor(private http: HttpClient) { }

  bookAppointment(appointment: Appointment): Observable<any> {
    return this.http.post(`${this.baseUrl}/bookAppointment`, appointment);
  }

  deleteAppointment(appointmentId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${appointmentId}`);
  }
}
