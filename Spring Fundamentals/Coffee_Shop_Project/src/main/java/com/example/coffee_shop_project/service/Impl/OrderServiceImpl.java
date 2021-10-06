package com.example.coffee_shop_project.service.Impl;

import com.example.coffee_shop_project.models.entities.Order;
import com.example.coffee_shop_project.models.service.OrderServiceModel;
import com.example.coffee_shop_project.repository.OrderRepository;
import com.example.coffee_shop_project.service.CategoryService;
import com.example.coffee_shop_project.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void add(OrderServiceModel orderServiceModel) {

        Order order = modelMapper.map(orderServiceModel, Order.class);

        order.setCategory(categoryService.findByName(orderServiceModel.getCategory()));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(orderServiceModel.getOrderTime(), dtf);

        order.setOrderTime(localDateTime);
        orderRepository.save(order);
    }
}
