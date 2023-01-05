package com.example.demoRestaurant1.service;

import com.example.demoRestaurant1.modelsecurity.JwtRequest;
import com.example.demoRestaurant1.modelsecurity.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface AuthenticationService {

        ResponseEntity<JwtResponse> authenticate(JwtRequest jwtRequest);
    }


