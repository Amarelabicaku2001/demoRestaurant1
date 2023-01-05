package com.example.demoRestaurant1.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue
    private int departmentId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;


}
