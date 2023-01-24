package com.users.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.users.entities.User;
import com.users.entities.UserDTO;

@Component
public class ConversionImpl implements Conversion{

	@Override
	public UserDTO entityToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getUserId());
		userDTO.setName(user.getUserName());
		userDTO.setEmail(user.getUserEmail());
		userDTO.setMobile(user.getUserMobile());
		userDTO.setCity(user.getUserCity());
		userDTO.setState(user.getUserState());
		userDTO.setAbout(user.getUserAbout());
		
		return userDTO;
	}

	@Override
	public List<UserDTO> entityToDTO(List<User> users) {
		
		List<UserDTO> userDTOs = users.stream().map(u->{
			UserDTO userDTO = this.entityToDTO(u);
			
			return userDTO;
		}).collect(Collectors.toList());
		
		return userDTOs;
	}

	@Override
	public User userDTOToEntity(UserDTO userDTO) {
		User user = new User();
		user.setUserId(userDTO.getId());
		user.setUserName(userDTO.getName());
		user.setUserEmail(userDTO.getEmail());
		user.setUserMobile(userDTO.getMobile());
		user.setUserCity(userDTO.getCity());
		user.setUserState(userDTO.getState());
		user.setUserAbout(userDTO.getAbout());
		
		return user;
	}

	@Override
	public List<User> userDTOToEntity(List<UserDTO> userDTO) {

		List<User> users = userDTO.stream().map(u->{
			User user = this.userDTOToEntity(u);
			return user;
		}).collect(Collectors.toList());
		
		return users;
	}

}
