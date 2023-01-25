package com.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.entities.UserDTO;
import com.users.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping
	ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		
		return ResponseEntity.ok(userService.createUser(userDTO));
	}
	
	@GetMapping(path = "/{id}")
	ResponseEntity<UserDTO> getUser(@PathVariable String id){
		
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	@GetMapping(path = "/name/{name}")
	ResponseEntity<List<UserDTO>> getUsersByName(@PathVariable String name){
		
		return ResponseEntity.ok(userService.getUsersByName(name));
	}
	
	@GetMapping(path = "/email/{email}")
	ResponseEntity<List<UserDTO>> getUsersByEmail(@PathVariable String email){
		
		return ResponseEntity.ok(userService.getUsersByEmail(email));
	}
	
	@GetMapping(path = "/mobile/{mobile}")
	ResponseEntity<List<UserDTO>> getUsersByMobile(@PathVariable String mobile){
		
		return ResponseEntity.ok(userService.getUsersByMobile(mobile));
	}
	
	@GetMapping(path = "/city/{city}")
	ResponseEntity<List<UserDTO>> getUsersByCity(@PathVariable String city){
		
		return ResponseEntity.ok(userService.getUsersByCity(city));
	}
	
	@GetMapping(path = "/state/{state}")
	ResponseEntity<List<UserDTO>> getUsersByState(@PathVariable String state){
		
		return ResponseEntity.ok(userService.getUsersByState(state));
	}
	
	@GetMapping
	ResponseEntity<List<UserDTO>> getAllUsers(){
		
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PutMapping(path = "/{id}")
	ResponseEntity<UserDTO> getAllUsers(@PathVariable String id, @RequestBody UserDTO userDTO){
		
		return ResponseEntity.ok(userService.updateUser(id,userDTO));
	}
	
	@DeleteMapping(path = "/{id}")
	ResponseEntity<String> deleteUser(@PathVariable String id){
		userService.deleteUser(id);
		return ResponseEntity.ok("User successfully deleted");
	}
}
