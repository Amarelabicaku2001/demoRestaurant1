package com.example.demoRestaurant1.ServiceImpl;

import com.example.demoRestaurant1.UserRepository.UserRepo;
import com.example.demoRestaurant1.model.User;
import com.example.demoRestaurant1.modelsecurity.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class MyUserDetailsService implements UserDetailsService {

private UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.findByUsername(username);
        return new MyUserDetails(user);
    }

}