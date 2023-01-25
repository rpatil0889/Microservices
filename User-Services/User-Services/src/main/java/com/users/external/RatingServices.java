package com.users.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.users.entities.RatingDTO;

@FeignClient(name = "RATING-SERVICES")
public interface RatingServices {
    
    @GetMapping(path = "ratings/user/{userId}")
    List<RatingDTO> geRatingDTO(@PathVariable String userId);

}
