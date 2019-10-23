package com.kappa.kindly.repository;

import com.kappa.kindly.model.CollectionPoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionPointRepository extends JpaRepository<CollectionPoint, Long> {
	
	CollectionPoint findById(long id);

}
