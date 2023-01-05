package com.example.demoRestaurant1.Dto;


import com.example.demoRestaurant1.model.Dish;
import com.example.demoRestaurant1.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMDto {
    private int menuId;
    private String description;
    private String day;
    private User user;
    private Dish dish;
}
