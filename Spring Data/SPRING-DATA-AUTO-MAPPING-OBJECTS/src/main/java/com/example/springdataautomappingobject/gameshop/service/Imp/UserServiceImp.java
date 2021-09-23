package com.example.springdataautomappingobject.gameshop.service.Imp;

import com.example.springdataautomappingobject.gameshop.domain.dtos.UserDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.UserLoginDto;
import com.example.springdataautomappingobject.gameshop.domain.dtos.UserRegisterDto;
import com.example.springdataautomappingobject.gameshop.domain.entities.Role;
import com.example.springdataautomappingobject.gameshop.domain.entities.User;
import com.example.springdataautomappingobject.gameshop.repositories.UserRepository;
import com.example.springdataautomappingobject.gameshop.service.GameService;
import com.example.springdataautomappingobject.gameshop.service.UserService;
import com.example.springdataautomappingobject.gameshop.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImp implements UserService {

    private final GameService gameService;
    private  final ValidatorUtil validatorUtil;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private UserDto loggedUser;

    @Autowired
    public UserServiceImp(GameService gameService, ValidatorUtil validatorUtil, UserRepository userRepository, ModelMapper modelMapper) {
        this.gameService = gameService;
        this.validatorUtil = validatorUtil;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {

        StringBuilder sb = new StringBuilder();

        if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            sb.append("Password don't match");
        }

        else if (this.validatorUtil.isValid(userRegisterDto)) {
            User user = this.modelMapper.map(userRegisterDto, User.class);

            if (userRepository.count() == 0) {
                user.setRole(Role.ADMIN);
            } else {
                user.setRole(Role.USER);
            }

            sb.append(String.format("%s was registered",userRegisterDto.getFullName()));
            this.userRepository.saveAndFlush(user);
        } else  {
            this.validatorUtil.violations(userRegisterDto)
                    .forEach(e -> sb.append(String.format("%s%n",e.getMessage())));
        }



        return sb.toString().trim();
    }

    @Override
    public String loginUser(UserLoginDto loginDto) {
        StringBuilder sb = new StringBuilder();

        Optional<User> user = this.userRepository.findAllByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());


        if(user.isPresent()) {

            if (this.loggedUser != null) {
                sb.append("User is already logged in.");
            } else {
                this.loggedUser = this.modelMapper.map(user.get(),UserDto.class);
                this.gameService.setLoggedUser(this.loggedUser);
                sb.append(String.format("Successfully logged in %s",user.get().getFullName()));
            }
        } else {
           sb.append("Incorrect email / password!");
        }




        return sb.toString().trim();
    }

    @Override
    public String logout() {

        if (this.loggedUser == null){
            return "Cannot log out. No user was logged in.";
        } else {
            String message = String.format("User %s successfully logged out",this.loggedUser.getFullName());
            this.loggedUser = null;
            return  message;
        }

    }
}
