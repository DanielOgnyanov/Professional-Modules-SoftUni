package com.example.music_db_project.service.Impl;

import com.example.music_db_project.models.UserServiceModel;
import com.example.music_db_project.repository.UserRepository;
import com.example.music_db_project.service.UserService;
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
    public void register(UserServiceModel map) {

    }
}
