package com.example.springdataautomappingobject.gameshop.service;

import com.example.springdataautomappingobject.gameshop.domain.dtos.AddGameDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.DeleteGameDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.UserDto;

public interface GameService {

    String addGame(AddGameDto addGameDto);

    void setLoggedUser(UserDto userDto);

    String deleteGame(DeleteGameDto deleteGameDto);
}
