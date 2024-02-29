package com.example.restaurant.service;

import com.example.restaurant.dto.RestaurantDTO;
import com.example.restaurant.entity.Restaurant;
import com.example.restaurant.mapper.RestaurantMapper;
import com.example.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repository;

    public List<RestaurantDTO> getAllRestaurant() {
        List<Restaurant> restaurantList = repository.findAll();
        return restaurantList.stream().map(RestaurantMapper.INTERFACE::mapRestauranttoRestaurantDTO).collect(Collectors.toList());
    }

    public RestaurantDTO store(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = RestaurantMapper.INTERFACE.mapRestaurantDTOtoRestaurant(restaurantDTO);
        return RestaurantMapper.INTERFACE.mapRestauranttoRestaurantDTO(restaurant);
    }

    public ResponseEntity<RestaurantDTO> fetchById(Integer id) {
        Optional<Restaurant> restaurant = repository.findById(id);
        if (restaurant.isPresent()) {
            return new ResponseEntity<>(RestaurantMapper.INTERFACE.mapRestauranttoRestaurantDTO(restaurant.get()), HttpStatus.Ok);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
