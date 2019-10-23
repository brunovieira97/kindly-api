package com.kappa.kindly.repository;

import com.kappa.kindly.model.Institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
	
	Institution findById(long id);

}
