package com.example.foodcatelog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.foodcatelog.dto.FoodCataloguePage;
import com.example.foodcatelog.dto.FoodItemDTO;
import com.example.foodcatelog.dto.Restaurant;
import com.example.foodcatelog.entity.FoodItem;
import com.example.foodcatelog.mapper.FoodItemMapper;
import com.example.foodcatelog.repository.FoodItemRepository;

@Service
public class FoodCatalogueService {

	@Autowired
	FoodItemRepository repository;

	@Autowired
	RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public FoodItemDTO save(FoodItemDTO foodItemDTO) {

		FoodItem foodItem = repository.save(FoodItemMapper.INTERFACE.mapFoodItemDTOToFoodItem(foodItemDTO));

		return FoodItemMapper.INTERFACE.mapFoodItemToFoodItemDTO(foodItem);
	}

	public FoodCataloguePage fetchFoodItemWithRestaurantId(int restaurantId) {
		List<FoodItem> foodItemList = repository.findByRestaurantId(restaurantId);

		Restaurant restaurant = fetchRestaurantById(restaurantId);

		return createFoodCataloguePage(foodItemList, restaurant);
	}

	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {

		FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
		foodCataloguePage.setFoodItemList(foodItemList);
		foodCataloguePage.setRestaurant(restaurant);
		return foodCataloguePage;
	}

	private Restaurant fetchRestaurantById(Integer restaurantId) {

		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/" + restaurantId, Restaurant.class);
	}

}
