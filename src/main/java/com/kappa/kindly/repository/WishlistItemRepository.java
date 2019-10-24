package com.kappa.kindly.repository;

import com.kappa.kindly.model.WishlistItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
	
	WishlistItem findById(long id);

}
