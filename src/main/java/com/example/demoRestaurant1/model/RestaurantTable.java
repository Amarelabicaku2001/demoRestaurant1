package com.example.demoRestaurant1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="restaurant_table")
public class RestaurantTable {
    @Id
    @GeneratedValue
    private int restaurantTableId;
    @Column(name="quantity")
    private int quantity;
    @Column(name="number")
    private int number;

}

