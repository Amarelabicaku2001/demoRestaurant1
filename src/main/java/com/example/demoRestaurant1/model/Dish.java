package com.example.demoRestaurant1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name="Dish")
@Entity
public class Dish {
    @Id
    @GeneratedValue
    private int dishId;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private int price;
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "dish_menu",
            joinColumns = { @JoinColumn(name = "menu_menu_id") },
            inverseJoinColumns = { @JoinColumn(name = "dish_dish_id")})
    private List<Menu> menu=new ArrayList<>();

    @ManyToMany
    @JsonIgnore

    @JoinTable(
            name = "dish_order",
            joinColumns = { @JoinColumn(name = "order_order_id") },
            inverseJoinColumns = { @JoinColumn(name = "dish_dish_id")})
    private List<Order> order= new ArrayList<>();
    @ManyToOne
    @JsonIgnore
    private User user;


}
