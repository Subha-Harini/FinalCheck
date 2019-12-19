package com.cognizant.retreivecompanyservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.retreivecompanyservice.model.User;
import com.cognizant.retreivecompanyservice.repository.UserRepository;





@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	
	
	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		AppUser appUser = null;
		User user = userRepository.findByName(userName);
		if(user == null) {
			throw new UsernameNotFoundException(userName);
		}
		else {
			appUser = new AppUser(user);
		}
		return appUser;
	}

}
