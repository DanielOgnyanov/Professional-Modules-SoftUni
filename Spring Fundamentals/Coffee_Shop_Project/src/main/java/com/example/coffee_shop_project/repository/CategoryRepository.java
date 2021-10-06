package com.example.coffee_shop_project.repository;

import com.example.coffee_shop_project.models.entities.Category;
import com.example.coffee_shop_project.models.entities.EnumCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(EnumCategory name);
}
