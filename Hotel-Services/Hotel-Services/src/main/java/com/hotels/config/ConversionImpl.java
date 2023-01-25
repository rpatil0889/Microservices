package com.hotels.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotels.entities.Hotel;
import com.hotels.entities.HotelDTO;
import com.hotels.entities.RatingDTO;
import com.hotels.external.RatingServices;

@Component
public class ConversionImpl implements Conversion{

	@Autowired
	RatingServices ratingServices;

	
	@Override
	public HotelDTO entityToDto(Hotel hotel) {
		HotelDTO dto = new HotelDTO();
		dto.setId(hotel.getHotelId());
		dto.setName(hotel.getHotelName());
		dto.setAddress(hotel.getHotelAddress());
		dto.setCity(hotel.getHotelCity());
		dto.setState(hotel.getHotelState());
		dto.setDescription(hotel.getHotelDescription());

		List<RatingDTO> rd = ratingServices.geRatingDTO(hotel.getHotelId());       
        dto.setRatings(rd);

        double overAllRatings = 0.0;
        for (RatingDTO ratingDTO : rd) {
           overAllRatings += ratingDTO.getRatings();
        }
        dto.setOverAllRtaings(overAllRatings);
		
		return dto;
	}

	@Override
	public List<HotelDTO> entityToDto(List<Hotel> users) {
		
		List<HotelDTO> list = users.stream().map(h->{
			
			return this.entityToDto(h);
			
		}).collect(Collectors.toList());
		
		return list;
	}

	@Override
	public Hotel dtoToEntity(HotelDTO dto) {
		Hotel hotel = new Hotel();
		hotel.setHotelId(dto.getId());
		hotel.setHotelName(dto.getName());
		hotel.setHotelAddress(dto.getAddress());
		hotel.setHotelCity(dto.getCity());
		hotel.setHotelState(dto.getState());
		hotel.setHotelDescription(dto.getDescription());
		
		return hotel;
	}

	@Override
	public List<Hotel> dtoToEntity(List<HotelDTO> dto) {
		List<Hotel> list = dto.stream().map(h->{
			return this.dtoToEntity(h);
		}).collect(Collectors.toList());
		
		return list;
	}
}
