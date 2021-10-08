package com.example.coffee_shop_project.service;

import com.example.coffee_shop_project.models.service.OrderServiceModel;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    void add(OrderServiceModel map);

    BigDecimal  getAllCategory();
}
