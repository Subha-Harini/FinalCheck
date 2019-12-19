package com.cognizant.uploadexcelservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.uploadexcelservice.model.User;
import com.cognizant.uploadexcelservice.repository.UsersRepository;




@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsersRepository userRepository;
	
	
	
	public AppUserDetailsService(UsersRepository userRepository) {
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
