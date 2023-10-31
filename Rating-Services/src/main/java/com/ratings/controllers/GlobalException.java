package com.ratings.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ratings.exceptions.InvalidInputException;
import com.ratings.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handlepublicResourceNotFoundException(ResourceNotFoundException ex) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("messange", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Map<String,Object>>handleInvalidInputException(InvalidInputException exception){
		Map<String, Object>map = new HashMap<>();
		map.put("message", exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(map);
	}
}
