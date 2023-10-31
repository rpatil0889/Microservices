package com.users.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException exception) {
		Map<String, Object> map = new HashMap<>();
		map.put("message", exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Map<String, Object>> handleInvalidInputException(InvalidInputException exception) {
		Map<String, Object> map = new HashMap<>();
		map.put("message", exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
}
