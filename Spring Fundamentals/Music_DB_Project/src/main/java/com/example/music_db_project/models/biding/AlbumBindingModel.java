package com.example.music_db_project.models.biding;

import com.example.music_db_project.models.entities.EnumArtist;
import com.example.music_db_project.models.entities.EnumGenre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumBindingModel {

    private Long id;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private int copies;
    private LocalDate releasedDate;
    private String producer;
    private EnumArtist artist;
    private EnumGenre genre;
    private String description;




}
