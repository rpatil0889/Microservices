package com.hotels.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hotels.entities.RatingDTO;


@FeignClient(name = "RATING-SERVICES")
public interface RatingServices {
    
    @GetMapping(path = "ratings/hotel/{hotelId}")
    List<RatingDTO> geRatingDTO(@PathVariable String hotelId);

}
