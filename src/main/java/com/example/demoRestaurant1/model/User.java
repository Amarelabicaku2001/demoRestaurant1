package com.example.demoRestaurant1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name="users_")
@Entity
public class User {
    @Id
    @GeneratedValue
    private int userId;
    @Column(name = "user_name")
    private String username;
    @Column(name = "sur_name")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "datecreated")
    private LocalDateTime dateCreated;
    @Column(name = "dateupdated")
    private LocalDateTime dateUpdated;

    @PrePersist
    public void prePersist() {
        dateCreated = LocalDateTime.now();

    }

    @PreUpdate
    public void preUpdate() {
        dateUpdated = LocalDateTime.now();
    }
    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private  Department department;
    @OneToOne
    @JsonIgnore
    private Bill bill;
    @OneToMany()
    @JsonIgnore
    private List<Menu> menu;
    @OneToMany
    @JsonIgnore
    private List<Products> products;
   @OneToMany
   @JsonIgnore
    private List<Dish> dish;

}


