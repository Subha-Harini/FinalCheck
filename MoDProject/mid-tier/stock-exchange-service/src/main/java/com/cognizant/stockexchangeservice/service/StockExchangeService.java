package com.cognizant.stockexchangeservice.service;

import java.util.List;
import java.util.Set;

import com.cognizant.stockexchangeservice.dto.CompanyDto;
import com.cognizant.stockexchangeservice.model.Company;
import com.cognizant.stockexchangeservice.model.StockExchange;

public interface StockExchangeService {
	public Set<StockExchange> getAllStockExchangeList();
	public void addStockExchange(StockExchange stockExchange);
	public StockExchange getStockExchangee(int id);
	public StockExchange getStockExchangeByName(String name);
	public Set<Object> getAllCompanyList(String StockExchangeName);
}
