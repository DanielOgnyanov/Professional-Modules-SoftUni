package com.example.coffee_shop_project.service;

import com.example.coffee_shop_project.models.entities.User;
import com.example.coffee_shop_project.models.service.UserServiceModel;

import java.util.Optional;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);


    Optional<User> findByUsername(String username);


}
