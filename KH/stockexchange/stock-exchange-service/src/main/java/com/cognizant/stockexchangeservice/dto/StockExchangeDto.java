package com.cognizant.stockexchangeservice.dto;

import java.util.Set;
import com.cognizant.stockexchangeservice.model.StockExchange;

public class StockExchangeDto {
	private Set<StockExchange> StockExchange;

	public StockExchangeDto() {
		super();
	}

	public StockExchangeDto(Set<com.cognizant.stockexchangeservice.model.StockExchange> stockExchange) {
		super();
		StockExchange = stockExchange;
	}

	public Set<StockExchange> getStockExchange() {
		return StockExchange;
	}

	public void setStockExchange(Set<StockExchange> stockExchange) {
		StockExchange = stockExchange;
	}

	@Override
	public String toString() {
		return "StockExchangeDto [StockExchange=" + StockExchange + "]";
	}
	
}
