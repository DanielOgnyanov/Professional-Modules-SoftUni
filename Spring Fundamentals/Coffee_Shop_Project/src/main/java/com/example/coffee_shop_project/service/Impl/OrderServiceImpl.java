package com.example.coffee_shop_project.service.Impl;

import com.example.coffee_shop_project.models.service.OrderServiceModel;
import com.example.coffee_shop_project.repository.OrderRepository;
import com.example.coffee_shop_project.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void add(OrderServiceModel map) {

    }
}
