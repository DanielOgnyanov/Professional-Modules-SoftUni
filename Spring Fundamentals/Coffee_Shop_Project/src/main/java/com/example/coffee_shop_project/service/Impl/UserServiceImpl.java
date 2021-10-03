package com.example.coffee_shop_project.service.Impl;

import com.example.coffee_shop_project.models.service.UserServiceModel;
import com.example.coffee_shop_project.repository.UserRepository;
import com.example.coffee_shop_project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {

    }
}
