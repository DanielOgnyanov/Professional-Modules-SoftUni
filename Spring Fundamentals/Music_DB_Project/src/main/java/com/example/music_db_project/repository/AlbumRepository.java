package com.example.music_db_project.repository;

import com.example.music_db_project.models.entities.Album;
import com.example.music_db_project.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("Select SUM(a.copies) From Album as a")
    BigDecimal allSoldCopies();

    @Query("SELECT a FROM Album a ORDER BY a.copies DESC")
    List<Album> findAllOrdered();
}
