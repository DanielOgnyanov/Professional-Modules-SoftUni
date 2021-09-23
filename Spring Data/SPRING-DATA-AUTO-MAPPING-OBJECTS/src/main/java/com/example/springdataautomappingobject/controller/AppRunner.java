package com.example.springdataautomappingobject.controller;

import com.example.springdataautomappingobject.gameshop.domain.dtos.AddGameDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.DeleteGameDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.UserLoginDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.UserRegisterDto;
import com.example.springdataautomappingobject.gameshop.service.GameService;
import com.example.springdataautomappingobject.gameshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class AppRunner implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public AppRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String [] tokens = reader.readLine().split("\\|");

        switch (tokens[0]) {


            case "RegisterUser":
                UserRegisterDto registerDto = new UserRegisterDto(tokens[1] , tokens[2], tokens[3], tokens[4]);

                System.out.println(this.userService.registerUser(registerDto));
                break;

            case "LoginUser":
                UserLoginDto loginDto = new UserLoginDto(tokens[1],tokens[2]);

                System.out.println(this.userService.loginUser(loginDto));
                break;

            case "Logout":
                System.out.println(this.userService.logout());

                break;

            case "AddGame":
                LocalDate date = LocalDate.parse(tokens[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                AddGameDto addGameDto = new AddGameDto(tokens[1], new BigDecimal(tokens[2]),
                        Double.parseDouble(tokens[3]), tokens[4],tokens[5], tokens[6],date);


                System.out.println(this.gameService.addGame(addGameDto));
                break;

            case "DeleteGame":
                DeleteGameDto deleteGameDto = new DeleteGameDto(Long.parseLong(tokens[1]));

                System.out.println(this.gameService.deleteGame(deleteGameDto));

                break;

        }
    }
}
