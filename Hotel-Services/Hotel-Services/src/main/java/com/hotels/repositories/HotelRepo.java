package com.hotels.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotels.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

	List<Hotel> findByHotelNameIgnoreCaseContaining(String name);
	List<Hotel> findByHotelAddressIgnoreCaseContaining(String address);
	List<Hotel> findByHotelCityIgnoreCaseContaining(String city);
	List<Hotel> findByHotelStateIgnoreCaseContaining(String state);
	List<Hotel> findByHotelDescriptionIgnoreCaseContaining(String desc);
}
