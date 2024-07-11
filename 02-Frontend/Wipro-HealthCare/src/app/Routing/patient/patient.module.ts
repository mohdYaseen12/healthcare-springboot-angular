import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientRoutingModule } from './patient-routing.module';
import { FormsModule } from '@angular/forms';
import { PatientRegisterComponent } from 'src/app/Components/patient/register-patient/register-patient.component';
import { UpdatePatientComponent } from 'src/app/Components/patient/update-patient/update-patient.component';
import { ViewPatientComponent } from 'src/app/Components/patient/view-patient/view-patient.component';
import { ViewDoctorComponent } from 'src/app/Components/doctor/view-doctor/view-doctor.component';
import { FetchDoctorComponent } from 'src/app/Components/patient/fetch-doctor/fetch-doctor.component';

@NgModule({
  declarations: [
    FetchDoctorComponent,
    ViewPatientComponent,
    PatientRegisterComponent,
    UpdatePatientComponent,
  ],
  imports: [CommonModule, PatientRoutingModule, FormsModule],
})
export class PatientModule {}
