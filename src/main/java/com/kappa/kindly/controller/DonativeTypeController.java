package com.kappa.kindly.controller;

import java.util.List;

import javax.validation.Valid;

import com.kappa.kindly.model.DonativeType;
import com.kappa.kindly.repository.DonativeTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/donativetype")
public class DonativeTypeController {

	@Autowired
	private DonativeTypeRepository donativeTypeRepository;


	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DonativeType> FindByID(@Valid @PathVariable(value = "id") long id) {

		if ((!donativeTypeRepository.existsById(id)) || (donativeTypeRepository.findById(id) == null))
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(donativeTypeRepository.findById(id));
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DonativeType>> FindAll() {
		
		return ResponseEntity.ok(donativeTypeRepository.findAll());
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<DonativeType> Create(@Valid @RequestBody DonativeType donativetype) {
		
		return ResponseEntity.ok(donativeTypeRepository.save(donativetype));
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<DonativeType> Update(@Valid @RequestBody DonativeType donativetype) {
		
		if (!donativeTypeRepository.existsById(donativetype.getId()))
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(donativeTypeRepository.save(donativetype));
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DonativeType> Delete(@Valid @PathVariable(value = "id") long id) {

		if (!donativeTypeRepository.existsById(id))
			return ResponseEntity.notFound().build();

		DonativeType donativetypeResponse = donativeTypeRepository.findById(id);
		donativeTypeRepository.deleteById(id);

		return ResponseEntity.ok(donativetypeResponse);
	}
}
