import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnregistrerReservationComponent } from './enregistrer-reservation.component';

describe('EnregistrerReservationComponent', () => {
  let component: EnregistrerReservationComponent;
  let fixture: ComponentFixture<EnregistrerReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnregistrerReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EnregistrerReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
