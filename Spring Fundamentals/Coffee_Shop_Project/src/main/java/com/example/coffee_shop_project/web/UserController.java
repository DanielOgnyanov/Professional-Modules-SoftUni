package com.example.coffee_shop_project.web;

import com.example.coffee_shop_project.models.biding.UserRegisterBidingModel;
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


    @GetMapping("/register")
    public String register(Model model) {

        if(!model.containsAttribute("userRegisterBidingModel")) {
            model.addAttribute("userRegisterBidingModel", new UserRegisterBidingModel());
        }

        return "register";
    }


    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBidingModel userRegisterBidingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addAttribute("userRegisterBidingModel",userRegisterBidingModel);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BidingResult.userRegisterBidingModel",
                    bindingResult);
            return "redirect:register";
        }



        return "redirect:/login";
    }

}
