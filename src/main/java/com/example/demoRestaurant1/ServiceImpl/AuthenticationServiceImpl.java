package com.example.demoRestaurant1.ServiceImpl;

import com.example.demoRestaurant1.modelsecurity.JwtRequest;
import com.example.demoRestaurant1.modelsecurity.JwtResponse;
import com.example.demoRestaurant1.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired

    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtility jwtUtility;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseEntity<JwtResponse> authenticate(JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
            final UserDetails userDetails= myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

            final String jwtToken= jwtUtility.generateToken(userDetails);
            return  ResponseEntity.ok(new JwtResponse(jwtToken));

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());

        }
    }
}

