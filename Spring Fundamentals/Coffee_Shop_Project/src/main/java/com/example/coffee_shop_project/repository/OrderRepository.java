package com.example.coffee_shop_project.repository;


import com.example.coffee_shop_project.models.entities.Category;
import com.example.coffee_shop_project.models.entities.EnumCategory;
import com.example.coffee_shop_project.models.entities.Order;
import com.example.coffee_shop_project.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("Select SUM(c.category.neededTime) From Order c")
    BigDecimal getAllCategoryFromDb();


    List<Order> findAllByCategory_Name(EnumCategory enumCategory);


}
