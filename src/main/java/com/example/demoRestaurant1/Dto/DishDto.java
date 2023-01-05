package com.example.demoRestaurant1.Dto;


import com.example.demoRestaurant1.model.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DishDto {

    private int dishId;
    private String name;
    private int price;
    private User user;
}
