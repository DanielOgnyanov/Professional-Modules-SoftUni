package com.example.music_db_project.models.view;

import com.example.music_db_project.models.entities.Artist;
import com.example.music_db_project.models.entities.EnumGenre;
import com.example.music_db_project.models.entities.User;

import java.math.BigDecimal;

public class AlbumViewModel {

    private Long id;
    private String name;
    private String imageUrl;
    private int copies;
    private BigDecimal price;
    private EnumGenre genre;
    private Artist artist;
    private User addedFrom;


    public AlbumViewModel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public EnumGenre getGenre() {
        return genre;
    }

    public void setGenre(EnumGenre genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public User getAddedFrom() {
        return addedFrom;
    }

    public void setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
    }
}
