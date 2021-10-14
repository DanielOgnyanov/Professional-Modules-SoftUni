package com.example.music_db_project.repository;

import com.example.music_db_project.models.entities.Album;
import com.example.music_db_project.models.entities.Artist;
import com.example.music_db_project.models.entities.EnumArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByName(EnumArtist name);
    Optional<Artist> findById(Long id);
}
