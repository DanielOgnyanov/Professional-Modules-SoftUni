package com.example.coffee_shop_project.service;

import com.example.coffee_shop_project.models.entities.EnumCategory;
import com.example.coffee_shop_project.models.entities.Order;
import com.example.coffee_shop_project.models.service.OrderServiceModel;
import com.example.coffee_shop_project.models.view.OrderViewModel;
import com.example.coffee_shop_project.models.view.UserViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    void add(OrderServiceModel map);

    BigDecimal  getAllCategory();

    List<OrderViewModel> findAllByCatName(EnumCategory enumCategory);

    void getReady(Long id);


}
