package com.example.demoRestaurant1.Dto;


import com.example.demoRestaurant1.model.Dish;
import com.example.demoRestaurant1.model.RestaurantTable;
import com.example.demoRestaurant1.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private int orderId;
    private String name;
    private int quantity;
    private LocalDateTime dateCreated;
    @PrePersist
    public void prePersist() {
        dateCreated = LocalDateTime.now();
    }
    private RestaurantTable restaurantTable;
    private User user;
    private List<Dish> dishList;

}
