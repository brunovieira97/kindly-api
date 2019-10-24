package com.kappa.kindly.controller;

import java.util.List;

import javax.validation.Valid;

import com.kappa.kindly.repository.DonationRepository;
import com.kappa.kindly.model.Donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/donation")
public class DonationController {

	@Autowired
	private DonationRepository donationRepository;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Donation> FindByID(@Valid @PathVariable(value = "id") long id) {

		if ((!donationRepository.existsById(id)) || (donationRepository.findById(id) == null))
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(donationRepository.findById(id));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Donation>> FindAll() {
		
		return ResponseEntity.ok(donationRepository.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Donation> Create(@Valid @RequestBody Donation donation) {
		
		return ResponseEntity.ok(donationRepository.save(donation));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Donation> Update(@Valid @RequestBody Donation donation) {
		
		if (!donationRepository.existsById(donation.getId()))
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(donationRepository.save(donation));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Donation> Delete(@Valid @PathVariable(value = "id") long id) {

		if (!donationRepository.existsById(id))
			return ResponseEntity.notFound().build();

		Donation donationResponse = donationRepository.findById(id);
		donationRepository.deleteById(id);

		return ResponseEntity.ok(donationResponse);
	}
}
