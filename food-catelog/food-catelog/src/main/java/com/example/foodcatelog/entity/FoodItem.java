package com.example.foodcatelog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private String itemDescription;

    private boolean isVeg;

    private Number price;

    private int restaurantId;

    @Column(nullable = false, columnDefinition = "integer DEFAULT 1")
    private Integer quantity;


    @PrePersist
    public void prePersist() {
        if (quantity == null) {
            quantity = 1;
        }
    }
}
