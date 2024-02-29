package com.example.restaurant.controller;

import com.example.restaurant.dto.RestaurantDTO;
import com.example.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;


    @GetMapping
    ResponseEntity<List<RestaurantDTO>> getRestaurants() {
        List<RestaurantDTO> restaurantDTOList = restaurantService.getAllRestaurant();
        return new ResponseEntity<>(restaurantDTOList, HttpStatus.OK);

    }

    @PostMapping
    ResponseEntity<RestaurantDTO> storeRestaurant(@RequestBody RestaurantDTO restaurantDTO) {

        RestaurantDTO restaurant = restaurantService.store(restaurantDTO);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<RestaurantDTO> fetchById(@PathVariable Integer id) {
        return restaurantService.fetchById(id);

    }
}
