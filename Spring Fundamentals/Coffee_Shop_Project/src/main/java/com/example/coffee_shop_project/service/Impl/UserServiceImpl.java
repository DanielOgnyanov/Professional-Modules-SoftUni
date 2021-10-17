package com.example.coffee_shop_project.service.Impl;

import com.example.coffee_shop_project.models.entities.User;
import com.example.coffee_shop_project.models.service.UserServiceModel;
import com.example.coffee_shop_project.models.view.UserViewModel;
import com.example.coffee_shop_project.repository.UserRepository;
import com.example.coffee_shop_project.security.CurrentUser;
import com.example.coffee_shop_project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {

        userRepository.save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {

        currentUser.setId(userServiceModel.getId());

        currentUser.setUsername(userServiceModel.getUsername());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllOrdersByCount() {
        return userRepository
                .findAllUserOrderByOrdersCount()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();

                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setCount((long) user.getOrders().size());

                    return userViewModel;
                }).collect(Collectors.toList());
    }


}
