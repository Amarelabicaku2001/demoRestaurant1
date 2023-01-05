package com.example.demoRestaurant1.Dto;


import com.example.demoRestaurant1.model.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    private int userId;
    private String username;
    private String surname;
    private String email;
    private String password;
    private String role;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Department department;

    @PrePersist
    public void prePersist() {
        dateCreated = LocalDateTime.now();

    }

    @PreUpdate
    public void preUpdate() {
        dateUpdated = LocalDateTime.now();
    }
}

