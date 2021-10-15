package com.example.music_db_project.models.view;

import com.example.music_db_project.models.entities.Artist;
import com.example.music_db_project.models.entities.EnumGenre;
import com.example.music_db_project.models.entities.User;

import java.math.BigDecimal;

public class AlbumViewModel {

    private Long id;
    private String name;
    private int copies;
    private BigDecimal price;
    private EnumGenre genre;
    private Artist artist;
    private User addedFrom;
}
