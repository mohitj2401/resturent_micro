package com.example.foodcatelog.mapper;

import com.example.foodcatelog.dto.FoodItemDTO;
import com.example.foodcatelog.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INTERFACE = Mappers.getMapper(FoodItemMapper.class);


    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);


}