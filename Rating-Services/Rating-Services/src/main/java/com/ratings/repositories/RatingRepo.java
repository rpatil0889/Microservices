package com.ratings.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratings.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating, String>{

	List<Rating> findByUserIdContaining(String userId);
	List<Rating> findByHotelIdContaining(String hotelId);
	List<Rating> findByRatingsGreaterThanEqual(boolean ratings);
	
}
