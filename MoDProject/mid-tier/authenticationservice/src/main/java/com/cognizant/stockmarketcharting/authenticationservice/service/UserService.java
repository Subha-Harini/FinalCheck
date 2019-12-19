package com.cognizant.stockmarketcharting.authenticationservice.service;

import java.util.List;

import com.cognizant.stockmarketcharting.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.stockmarketcharting.authenticationservice.model.User;

public interface UserService {
	
	public void signUp(User user) throws UserAlreadyExistsException;
	public List<User> getUser() ;
	public void updateUser(User user);
	public User getUserByName(String name);
	public User getUserById(int id);
}
