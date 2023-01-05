package com.example.demoRestaurant1.Controller;

import com.example.demoRestaurant1.modelsecurity.JwtRequest;
import com.example.demoRestaurant1.modelsecurity.JwtResponse;
import com.example.demoRestaurant1.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class SecurityControllerJwt {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest jwtRequest) {
        return authenticationService.authenticate(jwtRequest);
    }


}

