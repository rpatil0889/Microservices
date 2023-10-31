package com.hotels.entities;

import java.util.List;

import lombok.Data;

@Data
public class HotelDTO {

	private String id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String description;
	private double overAllRtaings;
	private List<RatingDTO> ratings;
	
}
