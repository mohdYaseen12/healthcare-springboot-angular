import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GetAllDoctorComponent } from 'src/app/Components/admin/get-all-doctor/get-all-doctor.component';
import { GetAllPatientComponent } from 'src/app/Components/admin/get-all-patient/get-all-patient.component';
import { GetDoctorComponent } from 'src/app/Components/admin/get-doctor/get-doctor.component';
import { GetPatientComponent } from 'src/app/Components/admin/get-patient/get-patient.component';
import { RegisterAdminComponent } from 'src/app/Components/admin/register-admin/register-admin.component';
import { UpdateDoctorComponent } from 'src/app/Components/admin/update-doctor/update-doctor.component';

const routes: Routes = [
  {path: 'admin/get-all-doctor', component: GetAllDoctorComponent},
  {path: 'admin/get-all-patient', component: GetAllPatientComponent},
  {path: 'admin/get-doctor', component: GetDoctorComponent},
  {path:'admin/get-patient', component:GetPatientComponent},
  {path: 'admin/register-admin', component: RegisterAdminComponent},
  {path: 'admin/update-doctor', component: UpdateDoctorComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
