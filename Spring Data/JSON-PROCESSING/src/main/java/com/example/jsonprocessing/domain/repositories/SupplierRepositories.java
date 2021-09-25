package com.example.jsonprocessing.domain.repositories;


import com.example.jsonprocessing.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepositories extends JpaRepository<Supplier, Long> {

}
