package com.example.coffee_shop_project.repository;

import com.example.coffee_shop_project.models.entities.EnumEmployee;
import com.example.coffee_shop_project.models.entities.User;
import com.example.coffee_shop_project.models.service.OrderServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(EnumEmployee username);

}
