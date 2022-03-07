import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InformarionBilletComponent } from './informarion-billet.component';

describe('InformarionBilletComponent', () => {
  let component: InformarionBilletComponent;
  let fixture: ComponentFixture<InformarionBilletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InformarionBilletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InformarionBilletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
