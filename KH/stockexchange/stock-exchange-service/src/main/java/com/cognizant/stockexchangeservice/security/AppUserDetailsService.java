package com.cognizant.stockexchangeservice.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.stockexchangeservice.model.Users;
import com.cognizant.stockexchangeservice.repository.UsersRepository;



@Service
public class AppUserDetailsService implements UserDetailsService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);
	@Autowired
	UsersRepository usersRepository;

	public AppUserDetailsService(UsersRepository repository) {
		LOGGER.info("start");
		this.usersRepository = repository;
		LOGGER.info("end");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("start");
		Users user = usersRepository.findByUserName(username);
		AppUser appUser = null;
		if(user == null) {
			throw new UsernameNotFoundException("UserName not exists!");
		}else {
			appUser = new AppUser(user);
		}
		LOGGER.info("start");
		return appUser;
	}
	
}
