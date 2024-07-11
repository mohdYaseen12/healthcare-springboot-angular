import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConductConsultationComponent } from './conduct-consultation.component';

describe('ConductConsultationComponent', () => {
  let component: ConductConsultationComponent;
  let fixture: ComponentFixture<ConductConsultationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConductConsultationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConductConsultationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
