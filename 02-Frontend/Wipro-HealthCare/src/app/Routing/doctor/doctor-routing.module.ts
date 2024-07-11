import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConductConsultationComponent } from 'src/app/Components/doctor/conduct-consultation/conduct-consultation.component';
import { GetAllConsultationsComponent } from 'src/app/Components/doctor/get-all-consultations/get-all-consultations.component';
import { GetConsultationComponent } from 'src/app/Components/doctor/get-consultation/get-consultation.component';
import { DoctorRegistrationComponent } from 'src/app/Components/doctor/register-doctor/register-doctor.component';
import { ViewAppointmentsComponent } from 'src/app/Components/doctor/view-appointments/view-appointments.component';
import { ViewDoctorComponent } from 'src/app/Components/doctor/view-doctor/view-doctor.component';

const routes: Routes = [
  { path: 'doctor/view-doctor', component: ViewDoctorComponent },
  { path: 'doctor/view-appointments', component: ViewAppointmentsComponent },
  { path: 'doctor/conduct-consultation', component: ConductConsultationComponent },
  { path: 'doctor/get-consultation', component: GetConsultationComponent },
  { path: 'doctor/get-all-consultations', component: GetAllConsultationsComponent },
  { path: 'admin/register-doctor', component: DoctorRegistrationComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DoctorRoutingModule {}
