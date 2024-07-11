import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { UpdateDoctorComponent } from 'src/app/Components/admin/update-doctor/update-doctor.component';
import { GetAllDoctorComponent } from 'src/app/Components/admin/get-all-doctor/get-all-doctor.component';
import { GetAllPatientComponent } from 'src/app/Components/admin/get-all-patient/get-all-patient.component';
import { GetDoctorComponent } from 'src/app/Components/admin/get-doctor/get-doctor.component';
import { GetPatientComponent } from 'src/app/Components/admin/get-patient/get-patient.component';
import { RegisterAdminComponent } from 'src/app/Components/admin/register-admin/register-admin.component';

@NgModule({
  declarations: [
    UpdateDoctorComponent,
    GetAllDoctorComponent,
    GetAllPatientComponent,
    GetDoctorComponent,
    GetPatientComponent,
    RegisterAdminComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
  ]
})
export class AdminModule { }
