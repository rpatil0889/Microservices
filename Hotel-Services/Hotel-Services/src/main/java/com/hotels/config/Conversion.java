package com.hotels.config;

import java.util.List;

import com.hotels.entities.Hotel;
import com.hotels.entities.HotelDTO;

public interface Conversion {

	HotelDTO entityToDto(Hotel user);
	
	List<HotelDTO>entityToDto(List<Hotel> users);
	
	Hotel dtoToEntity(HotelDTO userDTO);
	
	List<Hotel> dtoToEntity(List<HotelDTO> userDTO);
}
