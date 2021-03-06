package com.kappa.kindly.repository;

import java.util.List;

import com.kappa.kindly.model.Institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

	Institution findById(long id);

	@Query("Select I from Institution I Where I.name like %?1%")
	List<Institution> findByName(String name);

	@Query(value = "Select I.* " +
			"from institution I, " +
			  "wishlist W, " +
			  "wishlist_item WL, " +
			  "donative D " +
			"Where I.id = W.institution_id " +
			  "and w.id = WL.wishlist_id " +
			  "and D.id = WL.donative_id " +
			  "and D.description like %?1%", nativeQuery = true)
	List<Institution> findByDonative(String description);

	@Query(value = "Select * from institution I Order By I.id Desc Limit 3", nativeQuery = true)
	List<Institution> getLast3();
}
