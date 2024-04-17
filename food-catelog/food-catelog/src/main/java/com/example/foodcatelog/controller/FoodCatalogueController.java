package com.example.foodcatelog.controller;

import com.example.foodcatelog.dto.FoodCataloguePage;
import com.example.foodcatelog.dto.FoodItemDTO;
import com.example.foodcatelog.service.FoodCatalogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food-catalogue")
public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService service;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    ResponseEntity<FoodItemDTO> storeFoodItem(@RequestBody FoodItemDTO foodItemDTO) {

        FoodItemDTO savedFoodItemDTO = service.save(foodItemDTO);
        return new ResponseEntity<>(savedFoodItemDTO, HttpStatus.OK);
    }

    @GetMapping("/fooditem/{restaurantId}")
    ResponseEntity<FoodCataloguePage> getFoodItemByRestaurantId(@PathVariable int restaurantId) {
        FoodCataloguePage foodCataloguePage = service.fetchFoodItemWithRestaurantId(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.NOT_FOUND);
    }

}
