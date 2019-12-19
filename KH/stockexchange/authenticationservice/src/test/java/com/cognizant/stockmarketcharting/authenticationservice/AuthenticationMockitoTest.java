package com.cognizant.stockmarketcharting.authenticationservice;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
 import org.junit.runner.RunWith;


import com.cognizant.stockmarketcharting.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.stockmarketcharting.authenticationservice.model.User;
import com.cognizant.stockmarketcharting.authenticationservice.repository.UserRepository;
import com.cognizant.stockmarketcharting.authenticationservice.security.AppUserDetailsService;
import com.cognizant.stockmarketcharting.authenticationservice.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthenticationMockitoTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationMockitoTest.class);
	 UserRepository repository = Mockito.mock(UserRepository.class);
	 UserServiceImpl service = new UserServiceImpl(repository);
	 AppUserDetailsService appService = new AppUserDetailsService(repository);
	 
	 
	@Test(expected = UserAlreadyExistsException.class)
 	public void testForUserExist() throws UserAlreadyExistsException {
 		LOGGER.info("Start");
 		User user = new User(6,"Preetha","pwd","USER",  "preethaelago30@gmail.com", 766767666, "A");
 		when(repository.findByName("Preetha")).thenReturn(user);
 		service.signUp(user);
 		LOGGER.info("End");
 	}
 	@Test
 	public void newSignUp() throws UserAlreadyExistsException {
 		LOGGER.info("Start");
 		when(repository.findByName("Hari")).thenReturn(null);
 		User user = new User(7,"Hari","pwd","USER",  "harinisubha98@gmail.com", 766067666, "P");
 		service.signUp(user);
 		LOGGER.info("End");
 		
 	}
 	
 	@Test
 	public void mockTestLoadUserByUsername() {
 		LOGGER.info("Start");
 		when(repository.findByName("Hari")).thenReturn(createUser());
 		UserDetails user = appService.loadUserByUsername("Hari");
 		String expected = "pwd";
 		assertEquals(expected, user.getPassword());
 		LOGGER.info("End");
 	}
 	
 	User createUser(){
 		User user = new User(7,"Hari","pwd","USER",  "harinisubha98@gmail.com", 766067666, "A");
 		return user;
 	}
 	
 	@Test(expected = UsernameNotFoundException.class)
 	public void testLoadByUserNameNotFoundException() throws UsernameNotFoundException {
 		when(repository.findByName("Hari")).thenReturn(null);
 		appService.loadUserByUsername("Hari");
 	}
 	
 	@Test
 	public void updateUser() {
 		LOGGER.info("Start");
 		when(repository.save(createUser())).thenReturn(null);
 		service.updateUser(createUser());
 		LOGGER.info("End");
 
 	}
 	
 	@Test
 	public void getUserByUserName() {
 		LOGGER.info("Start");
 		String userName = "Hari";
 		when(repository.findByName(userName)).thenReturn(createUser());
 		service.getUserByName(userName);
 		LOGGER.info("End");
 
 	}
 	
 	@Test
 	public void getUserById() {
 		LOGGER.info("Start");
 		int id = 7;
 		when(repository.findById(id)).thenReturn(createUser());
 		service.getUserById(id);
 		LOGGER.info("End");
 
 	}
 	
 	@Test
 	public void getAllUsers() {
 		LOGGER.info("Start");
 		List<User> userList = new ArrayList();
 		userList.add(createUser());
 		when(repository.findAll()).thenReturn(userList);
 		service.getUser();
 		LOGGER.info("End");
 
 	}
}
