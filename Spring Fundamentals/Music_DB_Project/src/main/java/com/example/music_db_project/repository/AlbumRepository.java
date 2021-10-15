package com.example.music_db_project.repository;

import com.example.music_db_project.models.entities.Album;
import com.example.music_db_project.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("Select SUM(a.copies) From Album as a")
    BigDecimal allSoldCopies();
}
