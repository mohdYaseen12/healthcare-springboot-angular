import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home/home.component';
import { AdminHomepageComponent } from './Components/admin/admin-homepage/admin-homepage.component';
import { GetAllDoctorComponent } from './Components/admin/get-all-doctor/get-all-doctor.component';
import { GetAllPatientComponent } from './Components/admin/get-all-patient/get-all-patient.component';
import { GetPatientComponent } from './Components/admin/get-patient/get-patient.component';
import { RegisterAdminComponent } from './Components/admin/register-admin/register-admin.component';
import { UpdateDoctorComponent } from './Components/admin/update-doctor/update-doctor.component';
import { DoctorRegistrationComponent } from './Components/doctor/register-doctor/register-doctor.component';
import { ViewDoctorComponent } from './Components/doctor/view-doctor/view-doctor.component';
import { DoctorHomepageComponent } from './Components/doctor/doctor-homepage/doctor-homepage.component';
import { ViewAppointmentsComponent } from './Components/doctor/view-appointments/view-appointments.component';
import { ConductConsultationComponent } from './Components/doctor/conduct-consultation/conduct-consultation.component';
import { GetConsultationComponent } from './Components/doctor/get-consultation/get-consultation.component';
import { GetAllConsultationsComponent } from './Components/doctor/get-all-consultations/get-all-consultations.component';
import { PatientHomepageComponent } from './Components/patient/patient-homepage/patient-homepage.component';
import { AppointmentHomepageComponent } from './Components/appointment/appointment-homepage/appointment-homepage.component';
// import { AppointmentHomepageComponent } from './Components/appointment/appointment-homepage/appointment-homepage.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AdminHomepageComponent, children: [
    // { path: 'register', component: RegisterAdminComponent },
    // { path: 'register-doctor', component: DoctorRegistrationComponent },
    // { path: 'get-all-doctor', component: GetAllDoctorComponent },
    // { path: 'get-doctor', component: ViewDoctorComponent },
    // { path: 'get-all-patient', component: GetAllPatientComponent },
    // { path: 'get-Patient', component: GetPatientComponent },
    // { path: 'update-doctor', component: UpdateDoctorComponent }
  ]},
  {path: 'doctor', component: DoctorHomepageComponent, children: [
    // { path: 'admin/register-doctor', component: DoctorRegistrationComponent },
    // {path: 'doctor/view-appointment', component: ViewAppointmentsComponent},
    // {path: 'doctor/conduct-consultation', component: ConductConsultationComponent},
    // {path: 'doctor/view-doctor', component: ViewDoctorComponent},
    // {path: 'doctor/view-consultation', component: GetConsultationComponent},
    // {path: 'doctor/view-all-consultation', component: GetAllConsultationsComponent},
  ]},
  { path: 'patient', component: PatientHomepageComponent, children : [
    
  ]},
  { path : 'appointment', component : AppointmentHomepageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
