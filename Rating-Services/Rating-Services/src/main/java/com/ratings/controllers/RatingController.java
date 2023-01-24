package com.ratings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratings.entities.RatingDTO;
import com.ratings.services.RatingService;

@RestController
@RequestMapping(path = "/ratings")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<RatingDTO> createRatings(@RequestBody RatingDTO dto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(dto));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<RatingDTO> getRatingById(@PathVariable String id){
		
		return ResponseEntity.ok(ratingService.getRatingById(id));
	}
	
	@GetMapping(path = "/user/{id}")
	public ResponseEntity<List<RatingDTO>> getRatingByUserId(@PathVariable String id){
		
		return ResponseEntity.ok(ratingService.getRatingsByUserId(id));
	}
	
	@GetMapping(path = "/hotel/{id}")
	public ResponseEntity<List<RatingDTO>> getRatingByHotelId(@PathVariable String id){
		
		return ResponseEntity.ok(ratingService.getRatingsByHotelId(id));
	}
	
	@GetMapping
	public ResponseEntity<List<RatingDTO>> getAllRatings(){
		
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteRating(@PathVariable String id){
		ratingService.deleteRating(id);
		return ResponseEntity.ok("Rating deleted successfully");
	}
}
