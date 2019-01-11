package com.lagoon.LagoonBackend.impl;

import com.lagoon.LagoonBackend.dao.UserDao;
import com.lagoon.LagoonBackend.model.User;
import com.lagoon.LagoonBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
