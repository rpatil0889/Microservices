package com.users.config;

import java.util.List;

import com.users.entities.User;
import com.users.entities.UserDTO;

public interface Conversion {

	UserDTO entityToDTO(User user);
	
	List<UserDTO>entityToDTO(List<User> users);
	
	User userDTOToEntity(UserDTO userDTO);
	
	List<User> userDTOToEntity(List<UserDTO> userDTO);
	
}
