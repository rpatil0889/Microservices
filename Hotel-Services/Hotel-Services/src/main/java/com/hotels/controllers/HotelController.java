package com.hotels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.entities.HotelDTO;
import com.hotels.services.HotelService;

@RestController
@RequestMapping(path = "/hotels")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(dto));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<HotelDTO> getHotelById(@PathVariable String id) {
		return ResponseEntity.ok(hotelService.getHotelById(id));
	}
	
	@GetMapping(path = "/name/{name}")
	public ResponseEntity<List<HotelDTO>> getHotelByNames(@PathVariable String name) {
		return ResponseEntity.ok(hotelService.getHotelsByName(name));
	}
	
	@GetMapping(path = "/city/{city}")
	public ResponseEntity<List<HotelDTO>> getHotelsByCity(@PathVariable String city) {
		return ResponseEntity.ok(hotelService.getHotelsByCity(city));
	}
	
	@GetMapping(path = "/state/{state}")
	public ResponseEntity<List<HotelDTO>> getHotelsSate(@PathVariable String state) {
		return ResponseEntity.ok(hotelService.getHotelsByState(state));
	}
	
	@GetMapping()
	public ResponseEntity<List<HotelDTO>> getAllHotels() {
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	

	@PutMapping(path = "/{id}")
	public ResponseEntity<HotelDTO> updateHotel(@PathVariable String id, @RequestBody HotelDTO dto) {
		return ResponseEntity.ok(hotelService.updateHotel(id,dto));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable String id) {
		hotelService.deleteHotel(id);
		return ResponseEntity.ok("Hotel succesfull deleted");
	}
	
}
