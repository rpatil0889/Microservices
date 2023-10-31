package com.hotels.services;

import java.util.List;

import com.hotels.entities.HotelDTO;

public interface HotelService {

//	Create Hotel
	HotelDTO createHotel(HotelDTO hotelDTO);
	
//	Get hotel by id
	HotelDTO getHotelById(String id);
	
//	Get hotel by Name
	List<HotelDTO> getHotelsByName(String name);
	
//	Get hotel by city
	List<HotelDTO> getHotelsByCity(String city);
	
//	Get hotel by state
	List<HotelDTO> getHotelsByState(String state);
	
//	Get hotel containing description
	List<HotelDTO> getHotelsByDescription(String desc);
	
//	Get All hotels
	List<HotelDTO>getAllHotels();
	
//	Update hotel
	HotelDTO updateHotel(String id, HotelDTO hotelDTO);
	
//	Delete  hotel
	void deleteHotel(String id);
}
