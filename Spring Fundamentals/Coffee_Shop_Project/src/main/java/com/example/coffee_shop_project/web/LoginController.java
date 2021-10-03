package com.example.coffee_shop_project.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {


    @GetMapping("/login")
    public String register() {
        return "/login";
    }
}
