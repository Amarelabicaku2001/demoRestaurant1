package com.example.demoRestaurant1.modelsecurity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class JwtResponse {
        private String jwtToken;
    }

