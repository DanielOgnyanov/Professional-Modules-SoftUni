package com.example.coffee_shop_project.web;

import com.example.coffee_shop_project.models.biding.OrderBindingModel;
import com.example.coffee_shop_project.models.service.OrderServiceModel;
import com.example.coffee_shop_project.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/order-add")
    public String add(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/login";
        }

        if (!model.containsAttribute("orderBindingModel")) {
            model.addAttribute("orderBindingModel", new OrderBindingModel());
        }
        return "order-add";
    }



    @PostMapping("/order-add")
    public String addConfirm(@Valid OrderBindingModel orderBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("orderBindingModel", orderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderBindingModel", bindingResult);

            return "redirect:order-add";

        }


        orderService
                .add(modelMapper.map(orderBindingModel , OrderServiceModel.class));


        return "redirect:/";

    }



    @GetMapping("/ready/{id}")
    public String deleteOrderById(@PathVariable Long id) {

        orderService.getReady(id);

        return "redirect:/";
    }
}
