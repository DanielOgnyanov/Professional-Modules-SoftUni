package com.example.springdataintro.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Books  extends BaseEntity{

    private String title;
    private String description;
    private EditionType editionType;
    private BigDecimal price;
    private int copies;
    private LocalDate realiseDate;
    private AgeRestriction ageRestriction;
    private Set<Category> categories;
    private Author author;


    public Books() {
    }


    @Column(name = "title", nullable = false,length = 50)
    public String getTitle() {
        return title;
    }

    @Column(name = "description",length = 1000)
    public String getDescription() {
        return description;
    }

    @Enumerated(EnumType.ORDINAL)
    public EditionType getEditionType() {
        return editionType;
    }

    @Column(name = "price",nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "copies",nullable = false)
    public int getCopies() {
        return copies;
    }

    @Column(name = "realise_date")
    public LocalDate getRealiseDate() {
        return realiseDate;
    }

    @Enumerated(EnumType.ORDINAL)
    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Category> getCategories() {
        return categories;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setRealiseDate(LocalDate realiseDate) {
        this.realiseDate = realiseDate;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}
