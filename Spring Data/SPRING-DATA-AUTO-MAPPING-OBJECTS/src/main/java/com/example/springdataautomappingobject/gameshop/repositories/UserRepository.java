package com.example.springdataautomappingobject.gameshop.repositories;

import com.example.springdataautomappingobject.gameshop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findAllByEmailAndPassword(String email, String password);
}
