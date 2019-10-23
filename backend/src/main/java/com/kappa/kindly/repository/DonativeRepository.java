package com.kappa.kindly.repository;

import com.kappa.kindly.model.Donative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonativeRepository extends JpaRepository<Donative, Long> {

	Donative findById(long id);

}
