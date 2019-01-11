package com.lagoon.LagoonBackend.controller;

import com.lagoon.LagoonBackend.model.User;
import com.lagoon.LagoonBackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }
    
    @RequestMapping(value = "/user/userName", method = RequestMethod.POST)
    public User findByUserName(@RequestBody String userName) {
        return userService.findByUserName(userName);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }


}