package com.example.coffee_shop_project.web;


import com.example.coffee_shop_project.models.entities.EnumCategory;
import com.example.coffee_shop_project.security.CurrentUser;
import com.example.coffee_shop_project.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final OrderService orderService;
    private final CurrentUser currentUser;

    public HomeController(OrderService orderService, CurrentUser currentUser) {
        this.orderService = orderService;
        this.currentUser = currentUser;
    }


    @GetMapping("/")
    public String index(Model model) {
        if(currentUser.isAnonymous()){
            return "index";
        }

        model.addAttribute("totalTime", orderService.getAllCategory());

        model.addAttribute("drinks", orderService.findAllByCatName(EnumCategory.DRINK));
        model.addAttribute("cakes", orderService.findAllByCatName(EnumCategory.CAKE));
        model.addAttribute("coffee", orderService.findAllByCatName(EnumCategory.COFFEE));
        model.addAttribute("others", orderService.findAllByCatName(EnumCategory.OTHER));
        return "home";
    }




}
