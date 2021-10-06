package com.example.coffee_shop_project.models.service;

import com.example.coffee_shop_project.models.entities.Category;
import com.example.coffee_shop_project.models.entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private Category category;
    private String description;
    private User employee;
}
