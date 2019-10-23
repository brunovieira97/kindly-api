package com.kappa.kindly.repository;

import com.kappa.kindly.model.DonativeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonativeTypeRepository extends JpaRepository<DonativeType, Long> {
	
	DonativeType findById(long id);

}
