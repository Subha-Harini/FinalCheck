package com.cognizant.stockmarketcharting.authenticationservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.cognizant.stockmarketcharting.authenticationservice.AuthenticationserviceApplication;
import com.cognizant.stockmarketcharting.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.stockmarketcharting.authenticationservice.model.User;
import com.cognizant.stockmarketcharting.authenticationservice.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
    
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger( AuthenticationserviceApplication.class);


	@Override
	public void signUp(User user) throws UserAlreadyExistsException {
		 LOGGER.info("Start");
		   User userObject = userRepository.findByName(user.getName());
		   if(userObject !=  null) {
			   throw new UserAlreadyExistsException("User already exists");
		   }
		   else {
			   userRepository.save(user);
			
		   }
		   LOGGER.info("End");
	}

	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	
	
}
