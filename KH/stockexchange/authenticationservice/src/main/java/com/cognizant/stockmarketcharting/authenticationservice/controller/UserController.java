package com.cognizant.stockmarketcharting.authenticationservice.controller;


import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.stockmarketcharting.authenticationservice.AuthenticationserviceApplication;
import com.cognizant.stockmarketcharting.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.stockmarketcharting.authenticationservice.model.User;
import com.cognizant.stockmarketcharting.authenticationservice.service.UserService;


@RestController
@RequestMapping("/stockmarketcharting/users") 
public class UserController {
	
      private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationserviceApplication .class);
	
	  @Autowired
	  UserService userService;
	  
	  @Autowired
	  PasswordEncoder passwordEncoder;
	  
	
	  @PostMapping 
	  public void signUp(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		  LOGGER.info("Start");
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
		  userService.signUp(user);
		  LOGGER.info("End");
	 }
	  
	  @GetMapping
	  public List<User> getUsers() {
		 return userService.getUser();
	  }
	  
	    
	  @PutMapping("/new-password")
		public void updatePassword(@RequestBody @Valid User user)  {
			LOGGER.info("Start");
			String password = user.getPassword();
			user.setStatus("A");
			user.setPassword(passwordEncoder.encode(password));
			System.out.println(user);
			userService.updateUser(user);
			LOGGER.info("End");
		}
	  
	   
}
