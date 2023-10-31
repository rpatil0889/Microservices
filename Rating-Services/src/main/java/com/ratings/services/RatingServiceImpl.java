package com.ratings.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratings.config.Converter;
import com.ratings.entities.Rating;
import com.ratings.entities.RatingDTO;
import com.ratings.exceptions.ResourceNotFoundException;
import com.ratings.repositories.RatingRepo;
@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepo ratingRepo;
	
	@Autowired
	Converter converter;
	
	@Override
	public RatingDTO createRating(RatingDTO ratingDTO) {
		String id = UUID.randomUUID().toString();
		ratingDTO.setRatinId(id);
		return converter.entityToDto(ratingRepo.save(converter.dtoToEntity(ratingDTO)));
	}
	
	@Override
	public RatingDTO getRatingById(String ratingId) {
		Rating rating = ratingRepo.findById(ratingId).get();
		if (rating == null) {
			throw new ResourceNotFoundException("Ratings not found with id: "+ratingId);
		}
		return converter.entityToDto(rating);
	}

	@Override
	public List<RatingDTO> getRatingsByUserId(String userId) {
		
		
		return converter.entityToDto(ratingRepo.findByUserIdContaining(userId));
	}

	@Override
	public List<RatingDTO> getRatingsByHotelId(String hotelId) {
		
		return converter.entityToDto(ratingRepo.findByHotelIdContaining(hotelId));
	}

	@Override
	public List<RatingDTO> getRatingsByHotelsRatingsGreaterThan(boolean ratings) {
		
		return converter.entityToDto(ratingRepo.findByRatingsGreaterThanEqual(ratings));
	}

	@Override
	public List<RatingDTO> getAllRatings() {
		
		return converter.entityToDto(ratingRepo.findAll());
	}

	@Override
	public void deleteRating(String ratingId) {
		ratingRepo.deleteById(ratingId);
		
	}
}
