package com.kappa.kindly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.kappa.kindly.repository.InstitutionRepository;
import com.kappa.kindly.model.Institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/institution")
public class InstitutionController {

	@Autowired
	private InstitutionRepository institutionRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Institution> FindByID(@Valid @PathVariable(value = "id") long id) {

		if ((!institutionRepository.existsById(id)) || (institutionRepository.findById(id) == null))
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(institutionRepository.findById(id));
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<Institution>> Search(@RequestParam(required = false) String name, @RequestParam(required = false) String wishlistItemName) {

		if (name == null && wishlistItemName == null)
			return ResponseEntity.badRequest().build();
		
		List<Institution> results = new ArrayList<Institution>();

		if (name != null)
			results.addAll(institutionRepository.findByName(name));

		if(wishlistItemName != null)	
			results.addAll(institutionRepository.findByDonative(wishlistItemName));

		if (results.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(results);
	} 

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Institution>> FindAll() {
		
		return ResponseEntity.ok(institutionRepository.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Institution> Create(@Valid @RequestBody Institution institution) {
		
		return ResponseEntity.ok(institutionRepository.save(institution));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Institution> Update(@Valid @RequestBody Institution institution) {
		
		if (!institutionRepository.existsById(institution.getId()))
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(institutionRepository.save(institution));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Institution> Delete(@Valid @PathVariable(value = "id") long id) {

		if (!institutionRepository.existsById(id))
			return ResponseEntity.notFound().build();

		Institution institutionResponse = institutionRepository.findById(id);
		institutionRepository.deleteById(id);

		return ResponseEntity.ok(institutionResponse);
	}
}
