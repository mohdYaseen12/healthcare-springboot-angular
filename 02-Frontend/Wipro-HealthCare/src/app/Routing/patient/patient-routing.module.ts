import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FetchDoctorComponent } from 'src/app/Components/patient/fetch-doctor/fetch-doctor.component';
import { PatientRegisterComponent } from 'src/app/Components/patient/register-patient/register-patient.component';
import { UpdatePatientComponent } from 'src/app/Components/patient/update-patient/update-patient.component';
import { ViewPatientComponent } from 'src/app/Components/patient/view-patient/view-patient.component';

const routes: Routes = [
  { path: 'patient/doctor-view', component: FetchDoctorComponent },
  { path: 'patient/view-patient', component: ViewPatientComponent },
  { path: 'patient/register', component: PatientRegisterComponent },
  { path: 'patient/update', component: UpdatePatientComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PatientRoutingModule {}
