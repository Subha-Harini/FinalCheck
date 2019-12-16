package com.cognizant.stockmarketcharting.authenticationservice.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.stockmarketcharting.authenticationservice.AuthenticationserviceApplication;
import com.cognizant.stockmarketcharting.authenticationservice.exception.VerificationPendingException;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/stockmarketcharting")
public class AuthenticationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationserviceApplication.class);
	
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) throws VerificationPendingException{
		LOGGER.info("Start");
		Map<String, String> data = new HashMap();
		String userType = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().toArray()[0].toString();
		String status = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().toArray()[1].toString();
		String firstName = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().toArray()[2].toString();
		if(status.contentEquals("P")){
			throw new VerificationPendingException("verification pending");
		}
		else {
		data.put("token", generateJwt(getUser(authHeader)));
		data.put("userType", userType);
		data.put("status", status);
		data.put("name", firstName);
		return data;
		}
	
		
	}
	
	private String getUser(String authHeader) {
		LOGGER.info("Start");
		String encodedCredentials = authHeader.split(" ")[1];
		String decodedCredentials = new String (Base64.getDecoder().decode(encodedCredentials));
		 LOGGER.info("End");
		return decodedCredentials.split(":")[0];
	}
	
	 private String generateJwt(String user) {
		 LOGGER.info("Start");
		 JwtBuilder builder = Jwts.builder();
	        builder.setSubject(user);
	        builder.setIssuedAt(new Date());
	        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
	        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
	        String token = builder.compact();
	     LOGGER.info("End");
	     return token;
	 }

}
