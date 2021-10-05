package com.example.coffee_shop_project.models.biding;

import com.example.coffee_shop_project.models.entities.Category;
import com.example.coffee_shop_project.models.entities.EnumCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderBindingModel {


    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private EnumCategory category;
    private String description;
}
