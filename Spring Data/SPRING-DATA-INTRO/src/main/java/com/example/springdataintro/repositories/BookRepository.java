package com.example.springdataintro.repositories;


import com.example.springdataintro.entities.Author;
import com.example.springdataintro.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books,Long> {


    @Query("SELECT b FROM Books  AS b WHERE CONCAT(b.author.firstName , ' ' , b.author.lastName) = 'George Powell'" +
            "ORDER BY b.realiseDate DESC , b.title")
    List<Books> allBooksOfSpecificAuthor();

    List<Books> findAllByRealiseDateBefore(LocalDate localdate);

    List<Books> findAllByRealiseDateAfter(LocalDate localdate);
}
