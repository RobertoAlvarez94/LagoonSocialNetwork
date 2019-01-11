package com.lagoon.LagoonBackend.service;

import com.lagoon.LagoonBackend.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<User> findAllUsers(); //returns a list of all users
    User findByUserName(String userName); //returns user by giving string parameter username
    User save(User user); //saves user information in db
}
