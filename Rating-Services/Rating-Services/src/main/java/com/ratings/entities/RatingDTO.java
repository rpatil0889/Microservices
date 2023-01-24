package com.ratings.entities;

import lombok.Data;

@Data
public class RatingDTO {
	
	private String ratinId;
	private String userId;
	private String hotelId;
	private double ratings;
	private String feedback;

}
