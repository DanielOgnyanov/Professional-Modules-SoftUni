package com.example.springdataautomappingobject.gameshop.domain.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddGameDto {

    @Pattern(regexp = "[A-Z]+.+",message = "Invalid title")
    private String title;

    @DecimalMin(value = "0", message = "Price should be a positive number")
    private BigDecimal price;

    @Min(value = 0,message = "Size should be a positive number")
    private double size;

    @Length(min = 11,max = 11, message = "Not valid Youtube URL")
    private String trailer;

    @Pattern(regexp = "([http]+\\/\\/)+",message = "ImageThumbnail is invalid")
    private String imageThumbnail;

    @Length(min = 20,message = "Must be at least 20 symbols")
    private String description;


    private LocalDate realiseDate;

    public AddGameDto(String title, BigDecimal price, double size, String trailer, String imageThumbnail, String description, LocalDate realiseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.realiseDate = realiseDate;
    }

    public AddGameDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRealiseDate() {
        return realiseDate;
    }

    public void setRealiseDate(LocalDate realiseDate) {
        this.realiseDate = realiseDate;
    }
}
