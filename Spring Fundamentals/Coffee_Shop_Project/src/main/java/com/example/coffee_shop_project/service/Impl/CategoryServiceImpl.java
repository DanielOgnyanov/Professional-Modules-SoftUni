package com.example.coffee_shop_project.service.Impl;

import com.example.coffee_shop_project.models.entities.Category;
import com.example.coffee_shop_project.models.entities.EnumCategory;
import com.example.coffee_shop_project.repository.CategoryRepository;
import com.example.coffee_shop_project.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (categoryRepository.count() == 0) {

            Arrays.stream(EnumCategory.values())
                    .forEach(categoryValue -> {

                        Category category = new Category(categoryValue, categoryValue.getValue());

                        categoryRepository.save(category);

                    });
        }
    }

    @Override
    public Category findByName(EnumCategory enumCategory) {
        return categoryRepository.findByName(enumCategory).orElse(null);
    }


}