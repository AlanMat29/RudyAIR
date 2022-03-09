import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationBilletComponent } from './reservation-billet.component';

describe('ReservationBilletComponent', () => {
  let component: ReservationBilletComponent;
  let fixture: ComponentFixture<ReservationBilletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservationBilletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationBilletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
