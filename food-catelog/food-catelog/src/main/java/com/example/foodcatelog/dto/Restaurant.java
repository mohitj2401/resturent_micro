package com.example.foodcatelog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    private int id;

    private String name;

    private String address;

    private String city;

    private String description;
}
