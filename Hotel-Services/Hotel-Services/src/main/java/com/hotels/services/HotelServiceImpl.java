package com.hotels.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.config.Conversion;
import com.hotels.entities.Hotel;
import com.hotels.entities.HotelDTO;
import com.hotels.exceptions.ResourceNotFoundException;
import com.hotels.repositories.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepo hotelRepo;
	@Autowired
	private Conversion conversion;

	@Override
	public HotelDTO createHotel(HotelDTO hotelDTO) {
		String id = UUID.randomUUID().toString();
		hotelDTO.setId(id);
		
		return conversion.entityToDto(hotelRepo.save(conversion.dtoToEntity(hotelDTO)));
	}

	@Override
	public HotelDTO getHotelById(String id) {
		Hotel hotel = hotelRepo.findById(id).get();

		if (hotel == null) {
			throw new ResourceNotFoundException("Hotel not found with id: " + id);
		}
		
		return conversion.entityToDto(hotel);
	}

	@Override
	public List<HotelDTO> getHotelsByName(String name) {

		return conversion.entityToDto(hotelRepo.findByHotelNameIgnoreCaseContaining(name));
	}

	@Override
	public List<HotelDTO> getHotelsByCity(String city) {

		return conversion.entityToDto(hotelRepo.findByHotelCityIgnoreCaseContaining(city));
	}

	@Override
	public List<HotelDTO> getHotelsByState(String state) {

		return conversion.entityToDto(hotelRepo.findByHotelStateIgnoreCaseContaining(state));
	}

	@Override
	public List<HotelDTO> getHotelsByDescription(String desc) {

		return conversion.entityToDto(hotelRepo.findByHotelDescriptionIgnoreCaseContaining(desc));
	}

	@Override
	public List<HotelDTO> getAllHotels() {

		return conversion.entityToDto(hotelRepo.findAll());
	}

	@Override
	public HotelDTO updateHotel(String id, HotelDTO hotelDTO) {
		Hotel hotel = hotelRepo.findById(id).get();

		if (hotel == null) {
			throw new ResourceNotFoundException("Hotel not found with id: " + id);
		}

		hotelDTO.setId(id);
		
		return conversion.entityToDto(hotelRepo.save(conversion.dtoToEntity(hotelDTO)));
	}

	@Override
	public void deleteHotel(String id) {
		Hotel hotel = hotelRepo.findById(id).get();

		if (hotel == null) {
			throw new ResourceNotFoundException("Hotel not found with id: " + id);
		}
		hotelRepo.delete(hotel);
	}
}
