package com.example.music_db_project.models.biding;

import com.example.music_db_project.models.entities.EnumArtist;
import com.example.music_db_project.models.entities.EnumGenre;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumBindingModel {

    private String name;
    private String imageUrl;
    private BigDecimal price;
    private int copies;
    private LocalDate releasedDate;
    private String producer;
    private EnumArtist artist;
    private EnumGenre genre;
    private String description;


    public AlbumBindingModel() {
    }


    @Size(min = 3, max = 20 , message = "Name must be between 3 and 20 characters")
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 5, message = "Image url must be min 5 characters")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @DecimalMin("0")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public EnumArtist getArtist() {
        return artist;
    }

    public void setArtist(EnumArtist artist) {
        this.artist = artist;
    }

    public EnumGenre getGenre() {
        return genre;
    }

    public void setGenre(EnumGenre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
