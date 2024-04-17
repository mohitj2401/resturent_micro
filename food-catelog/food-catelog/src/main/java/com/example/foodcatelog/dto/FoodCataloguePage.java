package com.example.foodcatelog.dto;

import com.example.foodcatelog.entity.FoodItem;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FoodCataloguePage {

    private List<FoodItem> foodItemList;

    private Restaurant restaurant;
}
