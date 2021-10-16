package com.example.music_db_project.models.view;

import com.example.music_db_project.models.entities.EnumArtist;
import com.example.music_db_project.models.entities.EnumGenre;
import com.example.music_db_project.models.entities.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {

    private Long id;
    private String name;
    private String imageUrl;
    private int copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private EnumGenre genre;
    private String artistName;


    public AlbumViewModel() {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }


    public EnumGenre getGenre() {
        return genre;
    }

    public void setGenre(EnumGenre genre) {
        this.genre = genre;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }


}
