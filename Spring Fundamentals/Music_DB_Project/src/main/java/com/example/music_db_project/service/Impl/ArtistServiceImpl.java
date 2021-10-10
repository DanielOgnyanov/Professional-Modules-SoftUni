package com.example.music_db_project.service.Impl;

import com.example.music_db_project.models.entities.Artist;
import com.example.music_db_project.models.entities.EnumArtist;
import com.example.music_db_project.repository.ArtistRepository;
import com.example.music_db_project.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public void initArtistInDb() {
        if (artistRepository.count() == 0) {

            Arrays.stream(EnumArtist.values())
                    .forEach(artistValue ->{

                        Artist artist = new Artist(artistValue, artistValue.getDescription());

                        artistRepository.save(artist);

                    });

        }
    }
}
