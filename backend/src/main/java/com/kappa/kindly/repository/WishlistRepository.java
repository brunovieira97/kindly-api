package com.kappa.kindly.repository;

import com.kappa.kindly.model.Wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
	
	Wishlist findById(long id);

}
