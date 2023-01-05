package com.example.demoRestaurant1.service;


import com.example.demoRestaurant1.Dto.DishDto;
import com.example.demoRestaurant1.model.Dish;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface DishService {
    public Dish saveDish(Dish dish);
    public Dish getDishById(int dishId);


    DishDto createDishByCooker(DishDto dishDto);
}
