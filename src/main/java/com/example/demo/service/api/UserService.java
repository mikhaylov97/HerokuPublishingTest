package com.example.demo.service.api;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User saveUser(User user);
    void deleteUser(User user);
}
