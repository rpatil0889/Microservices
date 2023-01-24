package com.hotels.entities;

import lombok.Data;

@Data
public class HotelDTO {

	private String id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String description;
}
