import { TestBed } from '@angular/core/testing';

import { StockExchangeService } from './stock-exchange.service';

xdescribe('StockExchangeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StockExchangeService = TestBed.get(StockExchangeService);
    expect(service).toBeTruthy();
  });
});
