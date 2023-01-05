package com.example.demoRestaurant1.service;


import com.example.demoRestaurant1.Dto.UserDTO;
import com.example.demoRestaurant1.model.User;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public interface UserService {
    public User saveUser(User user);

    public User getUserById(int userId);

    public List<User> getAllUsers();
    public void deleteUser(int userId);
    public User updateUser(User user,int userId);



    UserDTO addUserToAnExistingDepartment(UserDTO userDTO);


}


