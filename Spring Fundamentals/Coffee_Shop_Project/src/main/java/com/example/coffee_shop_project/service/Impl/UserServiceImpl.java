package com.example.coffee_shop_project.service.Impl;

import com.example.coffee_shop_project.models.entities.User;
import com.example.coffee_shop_project.models.service.UserServiceModel;
import com.example.coffee_shop_project.repository.UserRepository;
import com.example.coffee_shop_project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {

        userRepository.save(modelMapper.map(userServiceModel, User.class));
    }
}
