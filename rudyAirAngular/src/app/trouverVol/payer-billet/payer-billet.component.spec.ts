import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PayerBilletComponent } from './payer-billet.component';

describe('PayerBilletComponent', () => {
  let component: PayerBilletComponent;
  let fixture: ComponentFixture<PayerBilletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PayerBilletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PayerBilletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
