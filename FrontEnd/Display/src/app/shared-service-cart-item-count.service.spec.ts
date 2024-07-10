import { TestBed } from '@angular/core/testing';

import { SharedServiceCartItemCountService } from './shared-service-cart-item-count.service';

describe('SharedServiceCartItemCountService', () => {
  let service: SharedServiceCartItemCountService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SharedServiceCartItemCountService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
