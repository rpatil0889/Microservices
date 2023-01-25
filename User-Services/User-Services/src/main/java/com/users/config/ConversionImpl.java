package com.users.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.users.entities.RatingDTO;
import com.users.entities.User;
import com.users.entities.UserDTO;
import com.users.external.HotelService;
import com.users.external.RatingServices;

@Component
public class ConversionImpl implements Conversion{

	@Autowired
	RatingServices ratingServices;

	@Autowired
	HotelService hotelService;

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


		List<RatingDTO> list = ratingServices.geRatingDTO(user.getUserId());

        List<RatingDTO> rDtos = list.stream().map(r -> {
            r.setHotel(hotelService.gHotelDTO(r.getHotelId()));
            return r;
        }).collect(Collectors.toList());
		
		userDTO.setRatings(rDtos);

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
