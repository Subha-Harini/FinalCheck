package com.cognizant.stockexchangeservice.dto;

import java.util.Set;

import com.cognizant.stockexchangeservice.model.Company;

public class CompanyStockDTO {
	private Set<Company> companyList;

	public Set<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(Set<Company> companyList) {
		this.companyList = companyList;
	}

	public CompanyStockDTO() {
		super();
	}

	public CompanyStockDTO(Set<Company> companyList) {
		super();
		this.companyList = companyList;
	}

	@Override
	public String toString() {
		return "CompanyStockDTO [companyList=" + companyList + "]";
	}
	
	
	
}
