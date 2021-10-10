package com.example.music_db_project.service.Impl;

import com.example.music_db_project.repository.ArtistRepository;
import com.example.music_db_project.service.ArtistService;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
}
