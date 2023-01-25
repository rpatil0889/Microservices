package com.users.entities;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {

	private String id;
	private String name;
	private String email;
	private String mobile;
	private String city;
	private String state;
	private String about;

	private List<RatingDTO> ratings;
}
