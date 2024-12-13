package com.example.login_finfirm.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.login_finfirm.model.User;
import com.example.login_finfirm.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		com.example.login_finfirm.model.User user = userRepository.findByUsername(username)
//				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//		return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
//				.password(user.getPassword()).roles("USER") // Or fetch roles from the database
//				.build();
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Fetch user details from the database based on the username
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		// Return the UserDetails (Note: password should be encoded in the database)
		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
				.password(user.getPassword()) // assuming password is already encoded
				.build();
	}
}
