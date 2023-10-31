package com.hotels.entities;

import lombok.Data;

@Data
public class RatingDTO {
	
	private String userId;
	private double ratings;
	private String feedback;

}
