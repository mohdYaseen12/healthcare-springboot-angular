import { Appointment } from "./appointment";

export interface Consultation {
  consultingId: number;
  currentSymptoms: string;
  physicalExamination: string;
  treatmentPlan: string;
  recommendedTests?: string;
  prescription: string;
  appointment?: Appointment;
}
