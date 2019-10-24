package com.kappa.kindly.repository;

import com.kappa.kindly.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	Address findById(long id);
	
}
