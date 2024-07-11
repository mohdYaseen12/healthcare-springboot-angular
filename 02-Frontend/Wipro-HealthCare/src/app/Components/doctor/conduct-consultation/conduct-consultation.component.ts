import { Component } from '@angular/core';
import { Consultation } from 'src/app/Models/consultation';
import { DoctorService } from 'src/app/Services/doctor.service';

@Component({
  selector: 'app-conduct-consultation',
  templateUrl: './conduct-consultation.component.html',
  styleUrls: ['./conduct-consultation.component.css']
})
export class ConductConsultationComponent {
  appointmentId!: number;
  consultation: Consultation = {
    currentSymptoms: '',
    physicalExamination: '',
    treatmentPlan: '',
    recommendedTests: '',
    prescription: '',
    consultingId: 0
  };
  response!: string;

  constructor(private doctorService: DoctorService) {}

  conductConsultation() {
    this.doctorService.conductConsultation(this.appointmentId, this.consultation).subscribe(
      _response => {
        this.response = 'Consultation conducted successfully.';
      },
      error => {
        this.response = 'Error conducting consultation: ' + error.message;
      }
    );
  }
}
