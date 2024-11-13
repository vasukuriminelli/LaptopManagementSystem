import { TestBed } from '@angular/core/testing';

import { FrontEndServiceServiceService } from './front-end-service-service.service';

describe('FrontEndServiceServiceService', () => {
  let service: FrontEndServiceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FrontEndServiceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
