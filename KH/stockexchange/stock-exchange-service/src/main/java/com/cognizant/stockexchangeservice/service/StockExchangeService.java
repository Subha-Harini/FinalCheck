package com.cognizant.stockexchangeservice.service;

import java.util.Set;

import com.cognizant.stockexchangeservice.model.StockExchange;

public interface StockExchangeService {
	public Set<StockExchange> getAllStockExchangeList();
	public void addStockExchange(StockExchange stockExchange);
	public Set<Object> getAllCompanyList(String StockExchangeName);
}
