package com.example.foodcatelog.service;

import com.example.foodcatelog.dto.FoodItemDTO;
import com.example.foodcatelog.entity.FoodItem;
import com.example.foodcatelog.mapper.FoodItemMapper;
import com.example.foodcatelog.repository.FoodItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepository repository;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    public FoodItemDTO save(FoodItemDTO foodItemDTO) {

        FoodItem foodItem = repository.save(FoodItemMapper.INTERFACE.mapFoodItemDTOToFoodItem(foodItemDTO));

        return FoodItemMapper.INTERFACE.mapFoodItemToFoodItemDTO(foodItem);
    }
}
