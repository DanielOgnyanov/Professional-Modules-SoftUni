package com.example.springdataautomappingobject.gameshop.service;

import com.example.springdataautomappingobject.gameshop.domain.dtos.UserLoginDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.UserRegisterDto;

public interface UserService {

    String registerUser(UserRegisterDto userRegisterDto);

    String loginUser(UserLoginDto loginDto);

    String logout();
}
