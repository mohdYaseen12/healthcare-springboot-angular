import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentHomepageComponent } from './appointment-homepage.component';

describe('AppointmentHomepageComponent', () => {
  let component: AppointmentHomepageComponent;
  let fixture: ComponentFixture<AppointmentHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointmentHomepageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppointmentHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
