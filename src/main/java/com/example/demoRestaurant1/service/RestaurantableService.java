package com.example.demoRestaurant1.service;


import com.example.demoRestaurant1.model.RestaurantTable;
import org.springframework.stereotype.Component;

@Component
public interface RestaurantableService {
    public RestaurantTable saveRestaurantTable(RestaurantTable restaurantTable);

    public RestaurantTable getRestaurantTable(int restaurantTableId);

}
