package com.kappa.kindly.controller;

import javax.validation.Valid;

import com.kappa.kindly.model.JwtRequest;
import com.kappa.kindly.model.JwtResponse;
import com.kappa.kindly.model.User;
import com.kappa.kindly.security.JwtTokenUtils;
import com.kappa.kindly.services.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtils tokenUtils;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@CrossOrigin
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> CreateAuthenticationToken(@RequestBody JwtRequest request) throws Exception {
		this.Authenticate(
			request.getEmail(),
			request.getPassword()
		);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

		final String token = tokenUtils.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@CrossOrigin
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<?> RegisterNewUser(@Valid @RequestBody User user) {

		if (userDetailsService.userExists(user.getEmail()))
			return ResponseEntity.badRequest().build();
		
		return ResponseEntity.ok(userDetailsService.createUser(user));
	}

	private void Authenticate(String email, String password) throws Exception {
		try {
			this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(email, password)
			);
		} catch (DisabledException disabledException) {
			throw new Exception("USER_DISABLED", disabledException);
		} catch (BadCredentialsException badCredentialsException) {
			throw new Exception("INVALID_CREDENTIALS", badCredentialsException);
		}
	}
}
