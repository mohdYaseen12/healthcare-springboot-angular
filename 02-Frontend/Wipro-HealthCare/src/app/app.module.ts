import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DoctorModule } from './Routing/doctor/doctor.module';
import { AdminModule } from './Routing/admin/admin.module';
import { HomeComponent } from './Components/home/home/home.component';
import { FooterComponent } from './Components/footer/footer/footer.component';
import { DoctorHomepageComponent } from './Components/doctor/doctor-homepage/doctor-homepage.component';
import { AdminHomepageComponent } from './Components/admin/admin-homepage/admin-homepage.component';
import { PatientHomepageComponent } from './Components/patient/patient-homepage/patient-homepage.component';
import { PatientModule } from './Routing/patient/patient.module';
import { AppointmentModule } from './Routing/appointment/appointment.module';

@NgModule({
  declarations: [AppComponent,  HomeComponent, FooterComponent, DoctorHomepageComponent, AdminHomepageComponent, PatientHomepageComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    DoctorModule,
    AdminModule,
    PatientModule,
    AppointmentModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
