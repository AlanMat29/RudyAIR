import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercheVolComponent } from './recherche-vol.component';

describe('RechercheVolComponent', () => {
  let component: RechercheVolComponent;
  let fixture: ComponentFixture<RechercheVolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RechercheVolComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercheVolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
