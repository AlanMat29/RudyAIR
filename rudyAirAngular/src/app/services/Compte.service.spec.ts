/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CompteService } from './Compte.service';

describe('Service: Compte', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CompteService]
    });
  });

  it('should ...', inject([CompteService], (service: CompteService) => {
    expect(service).toBeTruthy();
  }));
});
