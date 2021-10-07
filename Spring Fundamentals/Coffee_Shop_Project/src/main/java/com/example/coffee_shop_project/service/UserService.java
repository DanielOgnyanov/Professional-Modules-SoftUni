package com.example.coffee_shop_project.service;

import com.example.coffee_shop_project.models.entities.EnumEmployee;
import com.example.coffee_shop_project.models.entities.User;
import com.example.coffee_shop_project.models.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User findByUsername(EnumEmployee username);
}
