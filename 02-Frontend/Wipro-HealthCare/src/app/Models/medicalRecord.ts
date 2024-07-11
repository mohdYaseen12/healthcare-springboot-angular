import { Doctor } from './doctor';
import { Patient } from './patient';

export interface MedicalRecord {
  recordId: number;
  patient?: Patient;
  doctor?: Doctor;
  consultationDate: Date;
  diagnosis: string;
  treatment: string;
}
