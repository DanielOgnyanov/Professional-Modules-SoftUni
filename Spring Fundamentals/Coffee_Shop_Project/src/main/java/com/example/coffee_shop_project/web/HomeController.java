package com.example.coffee_shop_project.web;


import com.example.coffee_shop_project.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final OrderService orderService;

    public HomeController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        if(httpSession.getAttribute("user") == null){
            return "index";
        }

        model.addAttribute("totalTime", orderService.getAllCategory());

        model.addAttribute("")
        return "home";
    }




}
