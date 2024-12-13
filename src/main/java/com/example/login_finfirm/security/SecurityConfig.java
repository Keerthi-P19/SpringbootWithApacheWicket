package com.example.login_finfirm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.example.login_finfirm.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

	private final CustomUserDetailsService userDetailsService;

	public SecurityConfig(CustomUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/hello").authenticated().anyRequest().permitAll())
				.formLogin().and().csrf().disable();
		return http.build();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

//	private final CustomUserDetailsService userDetailsService;
//
//	// Constructor Injection of CustomUserDetailsService
//	public SecurityConfig(CustomUserDetailsService userDetailsService) {
//		this.userDetailsService = userDetailsService;
//	}
//
//	// Password encoder bean
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(); // You can change the encoder if needed
//	}
//
//	// AuthenticationManager bean
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//			throws Exception {
//		return authenticationConfiguration.getAuthenticationManager(); // Wiring the authentication manager
//	}
//
//	// SecurityFilterChain bean to define security rules
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests().requestMatchers("/hello").authenticated() // Only authenticated users can access '/hello'
//				.anyRequest().permitAll() // Allow all other requests
//				.and().formLogin() // Enable form-based login
//				.loginPage("/login") // Custom login page (you can change this if needed)
//				.permitAll() // Allow public access to the login page
//				.and().csrf().disable(); // CSRF disabled - be cautious if you're handling stateful sessions (use CSRF
//											// protection if needed)
//
//		return http.build();
//	}
//
//	// UserDetailsService bean - used to load user-specific data
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return userDetailsService; // Use the custom UserDetailsService
//	}

}
