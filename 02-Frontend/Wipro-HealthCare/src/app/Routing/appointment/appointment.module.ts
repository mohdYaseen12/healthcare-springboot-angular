import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppointmentRoutingModule } from './appointment-routing.module';
import { BookAppointmentComponent } from 'src/app/Components/appointment/book-appointment/book-appointment.component';
import { DeleteAppointmentComponent } from 'src/app/Components/appointment/delete-appointment/delete-appointment.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    BookAppointmentComponent,
    DeleteAppointmentComponent
  ],
  imports: [
    CommonModule,
    AppointmentRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ]
})
export class AppointmentModule { }
