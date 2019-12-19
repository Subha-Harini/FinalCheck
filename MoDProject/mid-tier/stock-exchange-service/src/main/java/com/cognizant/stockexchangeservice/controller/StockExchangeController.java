package com.cognizant.stockexchangeservice.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.stockexchangeservice.StockAlreadyExistsException;
import com.cognizant.stockexchangeservice.dto.StockExchangeDto;
import com.cognizant.stockexchangeservice.model.StockExchange;
import com.cognizant.stockexchangeservice.service.StockExchangeService;

@RestController
@RequestMapping("/stockmarketcharting")
public class StockExchangeController {
	
	@Autowired
	StockExchangeService stockExchangeService;
	
	@GetMapping("/list")
	public StockExchangeDto getAllStockExchangeList(){
		StockExchangeDto stockExchangeDto = new StockExchangeDto();
		stockExchangeDto.setStockExchange(this.stockExchangeService.getAllStockExchangeList());
		return stockExchangeDto;
	}
	
	@PostMapping("/list")
	public void addStockExchange(@RequestBody StockExchange stockExchange) throws StockAlreadyExistsException {
		StockExchange se = stockExchangeService.getStockExchangeByName(stockExchange.getStockExchange());
		if(se != null) {
			throw new StockAlreadyExistsException("Stock Exchange already exists");
		}
		else {
		this.stockExchangeService.addStockExchange(stockExchange);
		}
	}
	
	@PutMapping("/list")
	public void updateStockExchange(@RequestBody StockExchange stockExchange) {
		this.stockExchangeService.addStockExchange(stockExchange);
	}
	
	@GetMapping("/company-list/{stockExchangeName}")
	public Set<Object> getAllCompany(@PathVariable String stockExchangeName){	
		return  stockExchangeService.getAllCompanyList(stockExchangeName);
	}
	
	@GetMapping("/list/{id}")
	public StockExchange getStockExchangeById(@PathVariable int id){	
		return  stockExchangeService.getStockExchangee(id);
	}

}
