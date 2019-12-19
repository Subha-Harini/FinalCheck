package com.cognizant.retreivecompanyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.retreivecompanyservice.model.Company;
import com.cognizant.retreivecompanyservice.model.service.CompanyService;


@RestController
@RequestMapping("/stockmarketcharting/companies") 
public class CompanyController {
		@Autowired
	  CompanyService companyService;
	  
		@GetMapping
		  public List<Company> getCompanies() {
			 return companyService.getAllCompanies();
		  }
		
		@GetMapping("{id}")
		  public Company getCompanyById(@PathVariable int id) {
			 return companyService.getCompanyById(id);
		  }
}
