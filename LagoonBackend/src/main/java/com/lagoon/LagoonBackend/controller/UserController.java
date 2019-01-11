package com.lagoon.LagoonBackend.controller;

import com.lagoon.LagoonBackend.model.User;
import com.lagoon.LagoonBackend.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Map;


@RestController  //annotation for a REST controller
@RequestMapping("/user") //General mapping; any other mapping declared in this class will follow after /user
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestBody Map<String, String> json) throws ServletException {
        if(json.get("username") == null || json.get("password") == null){
            throw new ServletException("Please fill in username and password");
        }

        String userName = json.get("username");
        String password = json.get("password");

        User user = userService.findByUserName(userName);

        if(user == null) {
            throw new ServletException("Username not found!");
        }

        String pwd = user.getPassword();

        if(!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your username and password.");
        }

        return Jwts.builder().setSubject(userName).claim("roles","user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user){
        return userService.save(user);
    }
}
