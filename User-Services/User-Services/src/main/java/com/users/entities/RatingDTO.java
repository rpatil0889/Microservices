package com.users.entities;

import lombok.Data;

@Data
public class RatingDTO {
	
	private String hotelId;
	private double ratings;
	private String feedback;

	private HotelDTO hotel;

}
