package com.example.springdataintro.entities;


import javax.persistence.*;
import java.awt.print.Book;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity{

    private String firstName;
    private String lastName;
    private Set<Books> books;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
