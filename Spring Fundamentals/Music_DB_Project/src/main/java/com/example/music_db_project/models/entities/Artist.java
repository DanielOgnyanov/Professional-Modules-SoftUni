package com.example.music_db_project.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{

    private EnumArtist name;
    private String description;

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

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
