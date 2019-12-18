package com.cognizant.uploadexcelservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.uploadexcelservice.security.AppUserDetailsService;
import com.cognizant.uploadexcelservice.security.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
		@Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 LOGGER.info("START CONFIGURE AUTH MANAGER");
		 auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
		 LOGGER.info("END CONFIGURE AUTH MANAGER");
	    }
		
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	    	LOGGER.info("START PASSWORD ENCODER");
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	    	LOGGER.info("START CONFIGURE HTTPSECURITY");
	    	httpSecurity.cors();
	        httpSecurity.csrf().disable().httpBasic().and()
	            .authorizeRequests()
	            .antMatchers("/stock-exchange/stock-exchange-list").permitAll()
	            .and()
	            .addFilter(new JwtAuthorizationFilter(authenticationManager()));
	        LOGGER.info("END CONFIGURE HTTPSECURITY");
	    }
	    
}
