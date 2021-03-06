package com.cognizant.stockexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.stockexchangeservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByName(String name);
	
	User findByEmail(String email);
}
