package com.cognizant.uploadexcelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.uploadexcelservice.model.User;



@Repository
public interface UsersRepository extends JpaRepository<User, Integer>{

	User findByName(String userName);
	
	
	Object findByName(User user);
	
}
