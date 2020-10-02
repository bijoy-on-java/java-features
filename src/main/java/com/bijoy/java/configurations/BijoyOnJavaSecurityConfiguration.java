package com.bijoy.java.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Java Engineering: Spring Boot API security configuration to secure
 * application from any threats.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@EnableWebSecurity
@Configuration
public class BijoyOnJavaSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Java Engineering: Method to configure csrf token for the application. Note: I
	 * have disabled security at the moment for development need.
	 * 
	 * @param httpSecurity
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();
	}
}
