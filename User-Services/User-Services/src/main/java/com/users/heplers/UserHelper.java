package com.users.heplers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.users.config.Conversion;
import com.users.entities.RatingDTO;
import com.users.entities.User;
import com.users.entities.UserDTO;
import com.users.external.HotelService;
import com.users.external.RatingServices;

@Component
public class UserHelper {

    @Autowired
    private Conversion conversion;

    @Autowired
    private RatingServices ratingServices;

    @Autowired
    private HotelService hotelService;

    public UserDTO getDTO(User user) {

        UserDTO ud = conversion.entityToDTO(user);

        List<RatingDTO> list = ratingServices.geRatingDTO(ud.getId());

        List<RatingDTO> rDtos = list.stream().map(r -> {
            r.setHotel(hotelService.gHotelDTO(r.getHotelId()));
            return r;
        }).collect(Collectors.toList());

        ud.setRatings(rDtos);

        return ud;
    }

    public List<UserDTO> getDTO(List<User> users){
        List<UserDTO> userDTOs = users.stream().map(u->{
            return this.getDTO(u);
        }).collect(Collectors.toList());
        return userDTOs;
    }
}
