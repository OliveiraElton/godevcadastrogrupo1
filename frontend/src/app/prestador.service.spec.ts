import { TestBed } from '@angular/core/testing';

import { PrestadorService } from './prestador.service';

describe('PrestadorService', () => {
  let service: PrestadorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrestadorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
