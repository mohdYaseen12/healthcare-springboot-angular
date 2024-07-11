import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllConsultationsComponent } from './get-all-consultations.component';

describe('GetAllConsultationsComponent', () => {
  let component: GetAllConsultationsComponent;
  let fixture: ComponentFixture<GetAllConsultationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllConsultationsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllConsultationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
