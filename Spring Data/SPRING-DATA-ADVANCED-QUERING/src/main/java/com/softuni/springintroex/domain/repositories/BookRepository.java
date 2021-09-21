package com.softuni.springintroex.domain.repositories;

import com.softuni.springintroex.entities.AgeRestriction;
import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {



    Set<Book>  findAllByAgeRestriction(AgeRestriction ageRestriction);

    Set<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    Set<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal less, BigDecimal Greater);

    @Query("select b from Book as b where substring(b.releaseDate,0,4) not like :year")
    Set<Book> findAllByRealiseDateNotInYear(String year);


    Set<Book> findAllByReleaseDateIsLessThan(LocalDate localDate);

    Set<Book> findAllByAuthorLastNameStartingWith(String start);

    @Query("select count(b) from Book as b where length( b.title) > :length")
    int getNumberOfBooksWithTitleLength(int length);

    Book findAllByTitle(String title);

    Set<Book> findAllByTitleContaining(String contString);

}
