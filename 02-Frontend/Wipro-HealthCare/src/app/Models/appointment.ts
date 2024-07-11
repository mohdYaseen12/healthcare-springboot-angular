import { Time } from "@angular/common";
import { Doctor } from "./doctor";
import { Patient } from "./patient";

export interface Appointment{
    appointmentId: number;
    patient?: Patient;
    doctor?: Doctor;
    appointmentDate: Date;
    appointmentTime: Time;
    symptoms: string;
    status: string;
}
