package com.kappa.kindly.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.kappa.kindly.repository.UserRepository;
import com.kappa.kindly.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> FindByID(@Valid @PathVariable(value = "id") long id) {

		if ((!userRepository.existsById(id)) || (userRepository.findById(id) == null))
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(userRepository.findById(id));
	}

	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public ResponseEntity<User> FindByEmail(@Valid @PathVariable(value = "email") String email) {

		Optional<User> result = userRepository.findByEmail(email);

		if (!result.isPresent())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(result.get());
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> FindAll() {
		
		return ResponseEntity.ok(userRepository.findAll());
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> Update(@Valid @RequestBody User user) {
		
		if (!userRepository.existsById(user.getId()))
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(userRepository.save(user));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> Delete(@Valid @PathVariable(value = "id") long id) {

		if (!userRepository.existsById(id))
			return ResponseEntity.notFound().build();

		User userResponse = userRepository.findById(id);
		userRepository.deleteById(id);

		return ResponseEntity.ok(userResponse);
	}
}
