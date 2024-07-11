import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from '../Models/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private apiUrl = 'http://localhost:8080/doctor';

  constructor(private http: HttpClient) {}

  getDoctorById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/viewDoctor/${id}`);
  }

  getAppointments(doctorId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/viewAppointments/${doctorId}`);
  }

  conductConsultation(appointmentId: number, consultation: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/conductConsultation/${appointmentId}`, consultation);
  }

  updateConsultation(consultationId: number, consultation: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/updateConsultation/${consultationId}`, consultation);
  }

  deleteConsultation(consultationId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/deleteConsultation/${consultationId}`);
  }

  getConsultationById(consultationId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/getConsultation/${consultationId}`);
  }

  getAllConsultations(): Observable<any> {
    return this.http.get(`${this.apiUrl}/getAllConsultations`);
  }

  registerDoctor(doctor: Doctor): Observable<Doctor> {
    return this.http.post<Doctor>(`http://localhost:8080/admin/saveDoctor`, doctor);
  }
}
