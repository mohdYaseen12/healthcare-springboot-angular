import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookAppointmentComponent } from 'src/app/Components/appointment/book-appointment/book-appointment.component';
import { DeleteAppointmentComponent } from 'src/app/Components/appointment/delete-appointment/delete-appointment.component';

const routes: Routes = [
  { path: 'appointment/book-appointment', component: BookAppointmentComponent },
  { path: 'appointment/delete', component: DeleteAppointmentComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppointmentRoutingModule { }
