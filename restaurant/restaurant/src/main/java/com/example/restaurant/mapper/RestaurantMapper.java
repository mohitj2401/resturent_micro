package com.example.restaurant.mapper;

import com.example.restaurant.dto.RestaurantDTO;
import com.example.restaurant.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INTERFACE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOtoRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestauranttoRestaurantDTO(Restaurant restaurant);


}
