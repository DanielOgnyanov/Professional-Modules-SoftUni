package com.example.coffee_shop_project.repository;


import com.example.coffee_shop_project.models.entities.Order;
import com.example.coffee_shop_project.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
