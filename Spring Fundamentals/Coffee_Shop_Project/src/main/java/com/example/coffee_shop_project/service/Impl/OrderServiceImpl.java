package com.example.coffee_shop_project.service.Impl;

import com.example.coffee_shop_project.models.entities.EnumCategory;
import com.example.coffee_shop_project.models.entities.Order;
import com.example.coffee_shop_project.models.service.OrderServiceModel;
import com.example.coffee_shop_project.models.view.OrderViewModel;
import com.example.coffee_shop_project.models.view.UserViewModel;
import com.example.coffee_shop_project.repository.OrderRepository;
import com.example.coffee_shop_project.security.CurrentUser;
import com.example.coffee_shop_project.service.CategoryService;
import com.example.coffee_shop_project.service.OrderService;
import com.example.coffee_shop_project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public OrderServiceImpl(OrderRepository orderRepository,
                            CategoryService categoryService,
                            UserService userService,
                            ModelMapper modelMapper,
                            CurrentUser currentUser) {
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;


        this.currentUser = currentUser;
    }


    @Override
    public void add(OrderServiceModel orderServiceModel) {

        Order order = modelMapper.map(orderServiceModel, Order.class);

        order.setCategory(categoryService.findByName(orderServiceModel.getCategory()));


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(orderServiceModel.getOrderTime(), dtf);

        order.setOrderTime(localDateTime);
        order.setEmployee(userService.findById(currentUser.getId()));

        orderRepository.save(order);
    }

    @Override
    public BigDecimal getAllCategory() {
        return orderRepository.getAllCategoryFromDb();
    }

    @Override
    public List<OrderViewModel> findAllByCatName(EnumCategory enumCategory) {
        return orderRepository.findAllByCategory_Name(enumCategory).stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void getReady(Long id) {
        orderRepository.deleteById(id);
    }




}
