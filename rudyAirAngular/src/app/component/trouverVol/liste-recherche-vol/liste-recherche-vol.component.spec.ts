import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeRechercheVolComponent } from './liste-recherche-vol.component';

describe('ListeRechercheVolComponent', () => {
  let component: ListeRechercheVolComponent;
  let fixture: ComponentFixture<ListeRechercheVolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeRechercheVolComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeRechercheVolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
