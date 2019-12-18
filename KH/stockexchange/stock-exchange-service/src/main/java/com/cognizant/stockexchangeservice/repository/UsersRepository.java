package com.cognizant.stockexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.stockexchangeservice.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	Users findByUserName(String userName);
	
	@Query(value = "select u from Users u where u.userName = ?1")
	Users getMenuItems(String user);

	Object findByUserName(Users user);
	
}
