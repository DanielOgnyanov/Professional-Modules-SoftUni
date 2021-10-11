package com.example.music_db_project.web;

import com.example.music_db_project.service.UserService;
import org.modelmapper.ModelMapper;

public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
}
