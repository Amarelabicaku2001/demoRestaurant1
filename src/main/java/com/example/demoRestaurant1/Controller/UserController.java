package com.example.demoRestaurant1.Controller;

import com.example.demoRestaurant1.Dto.UserDTO;
import com.example.demoRestaurant1.model.User;
import com.example.demoRestaurant1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public ResponseEntity<User> saveUser(@RequestBody User user) {

        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/find/{userId}", method = RequestMethod.GET)

    public ResponseEntity<User> getUser(@PathVariable int userId) {

        return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);

    }

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)

    public ResponseEntity<List<User>> getUser() {

        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);

    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)

    public ResponseEntity<String> deleteUser(@PathVariable int userId) {

        userService.deleteUser(userId);
        return new ResponseEntity<String>("Sucess", HttpStatus.OK);

    }

    @RequestMapping(value = "/update/{userId}", method = RequestMethod.PUT)

    public ResponseEntity<User> update(@PathVariable int userId, @RequestBody User user) {
        return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.ACCEPTED);
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> addUserToAnExistingDepartment(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<UserDTO>(userService.addUserToAnExistingDepartment(userDTO), HttpStatus.CREATED);
    }
}

