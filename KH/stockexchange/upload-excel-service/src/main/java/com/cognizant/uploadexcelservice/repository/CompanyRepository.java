package com.cognizant.uploadexcelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.uploadexcelservice.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
