package com.cognizant.stockmarketcharting.authenticationservice;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognizant.stockmarketcharting.authenticationservice.controller.UserController;
import com.cognizant.stockmarketcharting.authenticationservice.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;



@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class AuthenticationserviceMockMVCTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UserController userController;
	
	@Test
	public void getAllUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/stockmarketcharting/users")).andExpect(status().isOk());
	}

	@Test
    public void newUser() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders
    		      .post("/stockmarketcharting/users")
    		      .content(asJsonString(new User(10,"Harin","pwd","USER",  "subhar31071998@gmail.com", 760067666, "P")))
    		      .contentType(MediaType.APPLICATION_JSON)
    		      .accept(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk());
    }
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	/*@Test
	public void testConfirmation() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/stockmarketcharting/users/confirmation/L7TU9EQYC1")).andExpect(status().isOk());
	}*/
}
