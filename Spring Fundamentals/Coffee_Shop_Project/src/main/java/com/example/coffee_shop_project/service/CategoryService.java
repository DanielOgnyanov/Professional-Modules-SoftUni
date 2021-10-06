package com.example.coffee_shop_project.service;

import com.example.coffee_shop_project.models.entities.Category;
import com.example.coffee_shop_project.models.entities.EnumCategory;

public interface CategoryService {
    void initCategories();
    Category findByName(EnumCategory enumCategory);
}
