package com.example.coffee_shop_project.web;

import com.example.coffee_shop_project.models.biding.OrderBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/order-add")
    public String add() {

        return "order-add";
    }



    @PostMapping("/order-add")
    public String addConfirm(@Valid OrderBindingModel orderBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("orderBindingModel", orderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderBindingModel", bindingResult);

            return "redirect:/order-add";

        }


        return "redirect:/";



    }
}
