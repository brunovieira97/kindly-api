package com.kappa.kindly.controller;

import java.util.List;

import javax.validation.Valid;

import com.kappa.kindly.model.Wishlist;
import com.kappa.kindly.repository.WishlistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wishlist")
public class WishlistController {

	@Autowired
	private WishlistRepository wishlistRepository;


	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Wishlist> FindByID(@Valid @PathVariable(value = "id") long id) {

		if ((!wishlistRepository.existsById(id)) || (wishlistRepository.findById(id) == null))
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(wishlistRepository.findById(id));
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Wishlist>> FindAll() {
		
		return ResponseEntity.ok(wishlistRepository.findAll());
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Wishlist> Create(@Valid @RequestBody Wishlist Wishlist) {
		
		return ResponseEntity.ok(wishlistRepository.save(Wishlist));
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Wishlist> Update(@Valid @RequestBody Wishlist Wishlist) {
		
		if (!wishlistRepository.existsById(Wishlist.getId()))
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(wishlistRepository.save(Wishlist));
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Wishlist> Delete(@Valid @PathVariable(value = "id") long id) {

		if (!wishlistRepository.existsById(id))
			return ResponseEntity.notFound().build();

		Wishlist WishlistResponse = wishlistRepository.findById(id);
		wishlistRepository.deleteById(id);

		return ResponseEntity.ok(WishlistResponse);
	}
}
