package com.kappa.kindly.repository;

import java.util.Optional;

import com.kappa.kindly.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(long id);

	@Query("Select U from User U where U.email = ?1")
	Optional<User> findByEmail(String email);
	
}
