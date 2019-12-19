package com.cognizant.retreivecompanyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.retreivecompanyservice.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
		public Company findById(int id);
}
