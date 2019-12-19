package com.cognizant.stockmarketcharting.authenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.stockmarketcharting.authenticationservice.model.Confirmation;
import com.cognizant.stockmarketcharting.authenticationservice.model.User;
import com.cognizant.stockmarketcharting.authenticationservice.repository.ConfirmationRepository;
import com.cognizant.stockmarketcharting.authenticationservice.repository.UserRepository;

@Service
public class ConfirmationService {
	

	@Autowired
	ConfirmationRepository confirmationRepository;
	@Autowired
	UserRepository userRepository;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public ConfirmationService(ConfirmationRepository confirmationRepository) {
		super();
		this.confirmationRepository = confirmationRepository;
	}

	public ConfirmationService() {
		super();
	}

	public ConfirmationService(ConfirmationRepository confirmationRepository, UserRepository userRepository) {
		super();
		this.confirmationRepository = confirmationRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	public String setTokenForConfirmation(String userName) {
		String token=randomAlphaNumeric();
		Confirmation confirmation = new Confirmation(1, token, userName);
		confirmationRepository.save(confirmation);
		return token;
	}
	
	
	@Transactional
	public void confirmMailAddress(String token) {
		Confirmation userConfirmation=confirmationRepository.findByToken(token);
		if(userConfirmation!=null) {
			confirmationRepository.delete(userConfirmation);
			User user = userRepository.findByName(userConfirmation.getUserName());
			user.setStatus("A");
			userRepository.save(user);
		}
	}
	
	public static String randomAlphaNumeric() {

		int count = 10;
		StringBuilder builder = new StringBuilder();

		while (count-- != 0) {

			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());

			builder.append(ALPHA_NUMERIC_STRING.charAt(character));

		}
		System.out.println("&^&&&&& ");
		System.out.println(builder.toString());
		return builder.toString();
	}
}
