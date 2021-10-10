package com.example.music_db_project.repository;

import com.example.music_db_project.models.entities.Album;
import com.example.music_db_project.models.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
