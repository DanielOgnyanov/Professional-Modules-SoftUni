package com.example.music_db_project.service;

import com.example.music_db_project.models.entities.Artist;
import com.example.music_db_project.models.entities.EnumArtist;

public interface ArtistService {

    void initArtistInDb();
    Artist findByName(EnumArtist enumArtist);
    Artist findById(Long id);
}
