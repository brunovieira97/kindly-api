package com.kappa.kindly.controller;

import java.util.List;

import javax.validation.Valid;

import com.kappa.kindly.model.CollectionPoint;
import com.kappa.kindly.repository.CollectionPointRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/collectionpoint")
public class CollectionPointController {

	@Autowired
	private CollectionPointRepository collectionPointRepository;


	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CollectionPoint> FindByID(@Valid @PathVariable(value = "id") long id) {

		if ((!collectionPointRepository.existsById(id)) || (collectionPointRepository.findById(id) == null))
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(collectionPointRepository.findById(id));
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CollectionPoint>> FindAll() {
		
		return ResponseEntity.ok(collectionPointRepository.findAll());
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CollectionPoint> Create(@Valid @RequestBody CollectionPoint collectionpoint) {
		
		return ResponseEntity.ok(collectionPointRepository.save(collectionpoint));
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<CollectionPoint> Update(@Valid @RequestBody CollectionPoint collectionpoint) {
		
		if (!collectionPointRepository.existsById(collectionpoint.getId()))
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(collectionPointRepository.save(collectionpoint));
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CollectionPoint> Delete(@Valid @PathVariable(value = "id") long id) {

		if (!collectionPointRepository.existsById(id))
			return ResponseEntity.notFound().build();

		CollectionPoint collectionpointResponse = collectionPointRepository.findById(id);
		collectionPointRepository.deleteById(id);

		return ResponseEntity.ok(collectionpointResponse);
	}
}
