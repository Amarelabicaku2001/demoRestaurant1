package com.example.demoRestaurant1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="menu")
public class Menu {
    @Id
    @GeneratedValue
    private int menuId;
    @Column(name="menu_description")
    private String description;
    @Column(name="day")
    private  String day;
    @ManyToMany(mappedBy = "menu",fetch = FetchType.EAGER,cascade =CascadeType.ALL )

    private List<Dish> dish=new ArrayList<>();
@ManyToOne
@JsonIgnore
private User user;
}