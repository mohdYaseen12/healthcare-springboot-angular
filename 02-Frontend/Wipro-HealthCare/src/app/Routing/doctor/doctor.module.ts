import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';  
import { DoctorRoutingModule } from './doctor-routing.module';
import { ConductConsultationComponent } from 'src/app/Components/doctor/conduct-consultation/conduct-consultation.component';
import { GetAllConsultationsComponent } from 'src/app/Components/doctor/get-all-consultations/get-all-consultations.component';
import { GetConsultationComponent } from 'src/app/Components/doctor/get-consultation/get-consultation.component';
import { ViewAppointmentsComponent } from 'src/app/Components/doctor/view-appointments/view-appointments.component';
import { ViewDoctorComponent } from 'src/app/Components/doctor/view-doctor/view-doctor.component';
import { DoctorRegistrationComponent } from 'src/app/Components/doctor/register-doctor/register-doctor.component';

@NgModule({
  declarations: [
    ViewDoctorComponent,
    ViewAppointmentsComponent,
    ConductConsultationComponent,
    GetConsultationComponent,
    GetAllConsultationsComponent,
    DoctorRegistrationComponent
  ],
  imports: [
    CommonModule,
    DoctorRoutingModule,
    FormsModule  
  ]
})
export class DoctorModule { }
