package com.hotels.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hotels.entities.Hotel;
import com.hotels.entities.HotelDTO;

@Component
public class ConversionImpl implements Conversion{

	@Override
	public HotelDTO entityToDto(Hotel hotel) {
		HotelDTO dto = new HotelDTO();
		dto.setId(hotel.getHotelId());
		dto.setName(hotel.getHotelName());
		dto.setAddress(hotel.getHotelAddress());
		dto.setCity(hotel.getHotelCity());
		dto.setState(hotel.getHotelState());
		dto.setDescription(hotel.getHotelDescription());
		
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
