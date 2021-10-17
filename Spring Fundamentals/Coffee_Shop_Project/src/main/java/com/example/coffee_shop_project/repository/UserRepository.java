package com.example.coffee_shop_project.repository;

import com.example.coffee_shop_project.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    @Query("select u from User u order by size(u.orders) desc ")
    List<User> findAllUserOrderByOrdersCount();

}
