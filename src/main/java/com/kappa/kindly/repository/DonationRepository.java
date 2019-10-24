package com.kappa.kindly.repository;

import com.kappa.kindly.model.Donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

	Donation findById(long id);

}
