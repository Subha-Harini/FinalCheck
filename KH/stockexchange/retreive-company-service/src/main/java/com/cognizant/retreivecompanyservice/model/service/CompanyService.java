package com.cognizant.retreivecompanyservice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.retreivecompanyservice.model.Company;
import com.cognizant.retreivecompanyservice.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	public List<Company> getAllCompanies(){
		return companyRepository.findAll();
	}
	
	public Company getCompanyById(int id) {
		return companyRepository.findById(id);
	}
	
}
