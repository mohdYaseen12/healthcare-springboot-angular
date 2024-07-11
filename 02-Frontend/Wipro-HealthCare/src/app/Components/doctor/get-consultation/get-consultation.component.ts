import { Component } from '@angular/core';
import { Consultation } from 'src/app/Models/consultation';
import { DoctorService } from 'src/app/Services/doctor.service';

@Component({
  selector: 'app-get-consultation',
  templateUrl: './get-consultation.component.html',
  styleUrls: ['./get-consultation.component.css'],
})
export class GetConsultationComponent {
  consultationId!: number;
  consultation?: Consultation;

  constructor(private doctorService: DoctorService) {}

  getConsultation() {
    this.doctorService.getConsultationById(this.consultationId).subscribe(
      (data: Consultation) => {
        this.consultation = data;
      },
      (error) => {
        console.error('Error fetching consultation', error);
      }
    );
  }
}
