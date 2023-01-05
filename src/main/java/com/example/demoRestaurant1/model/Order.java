package com.example.demoRestaurant1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name="order_")
@Entity
public class Order {
    @Id
    @GeneratedValue
    private int orderId;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @PrePersist
    public void prePersist() {
        dateCreated = LocalDateTime.now();
    }
    @ManyToOne
    private RestaurantTable restaurantTable;
//    @OneToOne
//    private Bill bill;
    @ManyToMany(mappedBy = "order")
    private List<Dish> dish=new ArrayList<>();
    @ManyToOne
    @JsonIgnore
    private User user;

}
