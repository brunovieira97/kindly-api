package com.kappa.kindly.repository;

import com.kappa.kindly.model.DonationItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationItemRepository extends JpaRepository<DonationItem, Long> {
	
	DonationItem findById(long id);

}
