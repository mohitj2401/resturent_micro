package com.example.foodcatelog.repository;

import com.example.foodcatelog.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    
}
