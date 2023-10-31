package com.ratings.config;

import java.util.List;

import com.ratings.entities.Rating;
import com.ratings.entities.RatingDTO;

public interface Converter {

	RatingDTO entityToDto(Rating rating);

	List<RatingDTO> entityToDto(List<Rating> ratings);
	
	Rating dtoToEntity(RatingDTO dto);
	
	List<Rating> dtoToEntity(List<RatingDTO> dto);
		
}
