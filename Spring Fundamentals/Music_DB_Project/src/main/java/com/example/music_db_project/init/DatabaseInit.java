package com.example.music_db_project.init;

import com.example.music_db_project.service.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ArtistService artistService;

    public DatabaseInit(ArtistService artistService) {
        this.artistService = artistService;
    }


    @Override
    public void run(String... args) throws Exception {
        artistService.initArtistInDb();
    }
}
