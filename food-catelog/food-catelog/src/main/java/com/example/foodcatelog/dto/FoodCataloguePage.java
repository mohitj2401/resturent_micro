package com.example.foodcatelog.dto;

import com.example.foodcatelog.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodCataloguePage {

    private List<FoodItem> foodItemList;

    private Restaurant restaurant;
}
