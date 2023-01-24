package com.ratings.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ratings.entities.Rating;
import com.ratings.entities.RatingDTO;

@Component
public class ConverterImpl implements Converter {

	@Override
	public RatingDTO entityToDto(Rating rating) {
		RatingDTO dto = new RatingDTO();
		dto.setRatinId(rating.getRatinId());
		dto.setUserId(rating.getUserId());
		dto.setHotelId(rating.getHotelId());
		dto.setRatings(rating.getRatings());
		dto.setFeedback(rating.getFeedback());
		
		return dto;
	}

	@Override
	public List<RatingDTO> entityToDto(List<Rating> ratings) {
		List<RatingDTO> list = ratings.stream().map(r->{
			return this.entityToDto(r);
		}).collect(Collectors.toList());
		
		return list;
	}

	@Override
	public Rating dtoToEntity(RatingDTO dto) {
		Rating rating = new Rating();
		rating.setRatinId(dto.getRatinId());
		rating.setUserId(dto.getUserId());
		rating.setHotelId(dto.getHotelId());
		rating.setRatings(dto.getRatings());
		rating.setFeedback(dto.getFeedback());
		
		return rating;
	}
	
	@Override
	public List<Rating> dtoToEntity(List<RatingDTO> dto) {
		List<Rating> list = dto.stream().map(r->{		
			return this.dtoToEntity(r);
		}).collect(Collectors.toList());
		
		return list;
	}
}
