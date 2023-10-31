package com.ratings.services;

import java.util.List;

import com.ratings.entities.RatingDTO;

public interface RatingService {

//	Create Rating
	RatingDTO createRating(RatingDTO ratingDTO);
	
//	Get Rating
	RatingDTO getRatingById(String ratingId);
	
//	Get Rating by User id
	List<RatingDTO> getRatingsByUserId(String userId);
	
//	Get Ratings by hotel id
	List<RatingDTO> getRatingsByHotelId(String hotelId);
	
//	Get Ratings by hotel ratings greater than
	List<RatingDTO> getRatingsByHotelsRatingsGreaterThan(boolean ratings);
	
//	Get	All ratings
	List<RatingDTO> getAllRatings();
	
//	Delete Ratings
	void deleteRating(String ratingId);	
}
