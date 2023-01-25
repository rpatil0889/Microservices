package com.users.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.users.entities.HotelDTO;

@FeignClient(name = "HOTEL-SERVICES")
public interface HotelService {
    
    @GetMapping(path = "/hotels/{hotelId}")
    HotelDTO gHotelDTO(@PathVariable String hotelId);
}
