package com.cognizant.stockexchangeservice.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.stockexchangeservice.dto.CompanyDto;
import com.cognizant.stockexchangeservice.model.Company;
import com.cognizant.stockexchangeservice.model.StockExchange;
import com.cognizant.stockexchangeservice.repository.StockExchangeRepository;

@Service
public class StockExchangeServiceImpl implements StockExchangeService{
	
	@Autowired
	StockExchangeRepository stockExchangeRepository;
	
	@Override
	public Set<StockExchange> getAllStockExchangeList() {
		return  this.stockExchangeRepository.getAllExchange();
	}

	@Override
	public void addStockExchange(StockExchange stockExchange) {
		 this.stockExchangeRepository.save(stockExchange);	
	}

	@Override
	public Set<Object> getAllCompanyList(String StockExchangeName) {
		return  this.stockExchangeRepository.getAllCompany(StockExchangeName);
		
	}

	@Override
	public StockExchange getStockExchangee(int id) {	
		return stockExchangeRepository.findById(id).get();
	}

	@Override
	public StockExchange getStockExchangeByName(String name) {
		
		return stockExchangeRepository.findByStockExchange(name);
	}
	

}
