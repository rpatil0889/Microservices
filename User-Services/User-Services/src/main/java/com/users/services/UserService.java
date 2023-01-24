package com.users.services;

import java.util.List;

import com.users.entities.UserDTO;

public interface UserService {

//	Create User
	UserDTO createUser(UserDTO userDTO);
	
//	Get user
	UserDTO getUser(String id);
	
//	Get all users
	List<UserDTO> getAllUsers();
	
//	Get users by Name
	List<UserDTO> getUsersByName(String name);
	
//	Get users by Email
	List<UserDTO> getUsersByEmail(String email);
	
//	Get users by Mobile Number
	List<UserDTO> getUsersByMobile(String mobile);
	
//	Get users by City
	List<UserDTO> getUsersByCity(String city);
	
//	Get users by State
	List<UserDTO> getUsersByState(String state);
	
//	Update user
	UserDTO updateUser(String id, UserDTO userDTO);
	
//	Delete user
	void deleteUser(String id);
}
