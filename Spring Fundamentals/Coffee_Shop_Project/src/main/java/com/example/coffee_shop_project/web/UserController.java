package com.example.coffee_shop_project.web;

import com.example.coffee_shop_project.models.biding.UserRegisterBidingModel;
import com.example.coffee_shop_project.models.service.UserServiceModel;
import com.example.coffee_shop_project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/register")
    public String register(Model model) {

        if(!model.containsAttribute("userRegisterBidingModel")) {
            model.addAttribute("userRegisterBidingModel", new UserRegisterBidingModel());
        }

        return "/register";
    }


    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBidingModel userRegisterBidingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors() || !userRegisterBidingModel.getPassword().equals(userRegisterBidingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegisterBidingModel",userRegisterBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBidingModel",
                    bindingResult);
            return "/register";
        }

        userService.register(modelMapper.map(userRegisterBidingModel, UserServiceModel.class));

        return "/login";
    }

}
