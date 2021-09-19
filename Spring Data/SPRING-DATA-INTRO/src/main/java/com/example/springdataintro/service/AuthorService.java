package com.example.springdataintro.service;

import com.example.springdataintro.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;
    int getAllAuthors();
    Author findAuthorById(Long id);
    List<Author> findAllAuthorsByCountOfBooks();
}
