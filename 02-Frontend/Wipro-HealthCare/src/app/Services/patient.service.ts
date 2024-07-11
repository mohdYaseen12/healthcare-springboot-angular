import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from '../Models/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private baseUrl = 'http://localhost:8080/patient';

  constructor(private http: HttpClient) {}

  registerPatient(patient: Patient): Observable<any> {
    return this.http.post(`${this.baseUrl}/save`, patient);
  }

  updatePatient(patientId: number, patient: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/updatePatient/${patientId}`, patient);
  }

  viewPatient(patientId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/viewPatient/${patientId}`);
  }

  fetchDoctor(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/fetchDoctor/${doctorId}`);
  }
}
