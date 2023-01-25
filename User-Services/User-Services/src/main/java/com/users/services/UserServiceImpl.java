package com.users.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.config.Conversion;
import com.users.entities.User;
import com.users.entities.UserDTO;
import com.users.exceptions.InvalidInputException;
import com.users.exceptions.ResourceNotFoundException;
import com.users.heplers.UserHelper;
import com.users.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private Conversion conversion;


	@Override
	public UserDTO createUser(UserDTO userDTO) {
		
		
		String id = UUID.randomUUID().toString();
		userDTO.setId(id);
		System.out.println(userDTO);
		
		if(!userRepo.findByUserEmailIgnoreCaseContaining(userDTO.getEmail()).isEmpty() && !userRepo.findByUserMobileIgnoreCaseContaining(userDTO.getMobile()).isEmpty()) {
			
			throw new InvalidInputException("User is alredy registered with email: "+userDTO.getEmail()+" mobile: "+ userDTO.getMobile());
		}
		else if (!userRepo.findByUserEmailIgnoreCaseContaining(userDTO.getEmail()).isEmpty()) {
			throw new InvalidInputException("User is alredy registered with email: "+userDTO.getEmail());

		}
		else if (!userRepo.findByUserMobileIgnoreCaseContaining(userDTO.getMobile()).isEmpty()) {
			throw new InvalidInputException("User is alredy registered with mobile: "+userDTO.getMobile());
			
		}
		User user = userRepo.save(conversion.userDTOToEntity(userDTO));
		
		return conversion.entityToDTO(user);
	}

	@Override
	public UserDTO getUser(String id) {
		User user = userRepo.findById(id).get();
		if (user==null) {
			throw new ResourceNotFoundException("User not found with id: "+id);
		}

		return conversion.entityToDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		
		return conversion.entityToDTO(userRepo.findAll());
	}

	@Override
	public List<UserDTO> getUsersByName(String name) {
		
		return conversion.entityToDTO(userRepo.findByUserNameIgnoreCaseContaining(name));
	}

	@Override
	public List<UserDTO> getUsersByEmail(String email) {
		
		return conversion.entityToDTO(userRepo.findByUserEmailIgnoreCaseContaining(email));
	}

	@Override
	public List<UserDTO> getUsersByMobile(String mobile) {
		
		return conversion.entityToDTO(userRepo.findByUserMobileIgnoreCaseContaining(mobile));
	}

	@Override
	public List<UserDTO> getUsersByCity(String city) {
		
		return conversion.entityToDTO(userRepo.findByUserCityIgnoreCaseContaining(city));
	}

	@Override
	public List<UserDTO> getUsersByState(String state) {
		
		return conversion.entityToDTO(userRepo.findByUserStateIgnoreCaseContaining(state));
	}

	@Override
	public UserDTO updateUser(String id, UserDTO userDTO) {
		if(!userRepo.findById(id).isPresent()) {
			throw new ResourceNotFoundException("User is not found with id: "+ id);
		}
		User user = conversion.userDTOToEntity(userDTO);
		user.setUserId(id);
		
		return conversion.entityToDTO(userRepo.save(user));
	}

	@Override
	public void deleteUser(String id) {
		if(!userRepo.findById(id).isPresent()) {
			throw new ResourceNotFoundException("User is not found with id: "+ id);
		}
		userRepo.deleteById(id);
	}
}
