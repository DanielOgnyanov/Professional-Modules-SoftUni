package com.example.music_db_project.service;

import com.example.music_db_project.models.entities.Artist;
import com.example.music_db_project.models.entities.User;
import com.example.music_db_project.models.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);
    User findById(Long id);
}
