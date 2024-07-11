import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../Models/admin';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  private baseUrl = 'http://localhost:8080/admin';

  constructor(private http: HttpClient) {}

  registerAdmin(admin: Admin): Observable<any> {
    return this.http.post(`${this.baseUrl}/save`, admin);
  }

  getAllDoctor(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getAllDoctor`);
  }

  getAllPatient(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getAllPatient`);
  }

  getDoctor(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getDoctor/${doctorId}`);
  }

  getPatient(patientId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getPatient/${patientId}`);
  }

  updateDoctor(doctorId: number, doctor: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/updateDoctor/${doctorId}`, doctor);
  }

  deleteDoctor(doctorId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteDoctor/${doctorId}`);
  }

  deletePatient(patientId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deletePatient/${patientId}`);
  }
}
