package com.example.springdataintro.service;

import com.example.springdataintro.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;
    Category getCategory(Long id);
}
