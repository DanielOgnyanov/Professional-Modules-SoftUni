package com.example.music_db_project.models.service;

import com.example.music_db_project.models.entities.EnumArtist;

public class ArtistServiceModel {

    private Long id;
    private EnumArtist name;
    private String careerInformation;

    public ArtistServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumArtist getName() {
        return name;
    }

    public void setName(EnumArtist name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
