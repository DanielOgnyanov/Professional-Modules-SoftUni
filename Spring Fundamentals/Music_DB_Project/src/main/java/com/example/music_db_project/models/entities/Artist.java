package com.example.music_db_project.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{

    private EnumArtist name;
    private String careerInformation;

    public Artist() {
    }


    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public EnumArtist getName() {
        return name;
    }

    public void setName(EnumArtist name) {
        this.name = name;
    }

    @Column(name = "career_information", columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String description) {
        this.careerInformation = description;
    }
}
