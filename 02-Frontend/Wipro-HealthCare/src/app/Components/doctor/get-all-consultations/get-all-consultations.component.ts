import { Component, OnInit } from '@angular/core';
import { Consultation } from 'src/app/Models/consultation';
import { DoctorService } from 'src/app/Services/doctor.service';

@Component({
  selector: 'app-get-all-consultations',
  templateUrl: './get-all-consultations.component.html',
  styleUrls: ['./get-all-consultations.component.css'],
})
export class GetAllConsultationsComponent implements OnInit {
  consultations: Consultation[] = [];
  response: string = '';

  constructor(private doctorService: DoctorService) {}

  ngOnInit() {
    this.doctorService.getAllConsultations().subscribe(
      (data: Consultation[]) => {
        this.consultations = data;
      },
      (error) => {
        console.error('Error fetching consultations', error);
      }
    );
  }

  deleteConsultation(consultationId: number) {
    this.doctorService.deleteConsultation(consultationId).subscribe(
      () => {
        this.response = 'Consultation deleted successfully.';
        this.consultations = this.consultations.filter(
          (consultation) => consultation.consultingId !== consultationId
        );
      },
      (error) => {
        this.response = 'Error deleting consultation: ' + error.message;
      }
    );
  }
}
