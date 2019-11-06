package com.kappa.kindly.services;

import java.util.ArrayList;
import java.util.Optional;

import com.kappa.kindly.model.User;
import com.kappa.kindly.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptEncoder;
	
	public UserDetails loadUserByUsername(String email) {
		
		Optional<User> user = userRepository.findByEmail(email);

		if (!user.isPresent())
			throw new UsernameNotFoundException("User not found with e-mail " + email);

		return new org.springframework.security.core.userdetails.User(
			user.get().getEmail(),
			user.get().getPassword(),
			new ArrayList<>()
		);
	}

	public User createUser(User user) {

		// Overwrite user's password with it's hash
		user.setPassword(bCryptEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}

	public boolean userExists(String email) {
		Optional<User> user = userRepository.findByEmail(email);

		if (!user.isPresent())
			return false;

		return true;
	}
}
