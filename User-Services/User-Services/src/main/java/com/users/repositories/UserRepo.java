package com.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.entities.User;

public interface UserRepo extends JpaRepository<User, String>{

	List<User> findByUserNameIgnoreCaseContaining(String name);
	List<User> findByUserEmailIgnoreCaseContaining(String userEmail);
	List<User> findByUserMobileIgnoreCaseContaining(String userMobile);
	List<User> findByUserCityIgnoreCaseContaining(String userCity);
	List<User> findByUserStateIgnoreCaseContaining(String userState);
}
