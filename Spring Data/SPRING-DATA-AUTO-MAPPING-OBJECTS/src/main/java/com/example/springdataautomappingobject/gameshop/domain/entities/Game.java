package com.example.springdataautomappingobject.gameshop.domain.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity{

    private String title;
    private String trailer;
    private String imageThumbnail;
    private double size;
    private BigDecimal price;
    private String description;
    private LocalDate realiseDate;
    private Set<User> user;


    @ManyToMany(mappedBy = "games")
    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Game() {
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "trailer")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    @Column(name = "image_thumbnail")
    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }
    @Column(name = "size")
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "realise_date")
    public LocalDate getRealiseDate() {
        return realiseDate;
    }

    public void setRealiseDate(LocalDate realiseDate) {
        this.realiseDate = realiseDate;
    }
}
