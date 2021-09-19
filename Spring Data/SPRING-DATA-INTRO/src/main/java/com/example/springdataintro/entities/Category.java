package com.example.springdataintro.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private String name;
    private Set<Books> books;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }



    @Column(name = "name",nullable = false,unique = true)
    public String getName() {
        return name;
    }


    @ManyToMany(mappedBy = "categories")
    public Set<Books> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }


}
