package com.example.springdataintro.service;

import com.example.springdataintro.entities.Books;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Books> getAllBooksAfter2000();
    List<Books> getAllNamesOfAuthorWithBookBefore1990();
    List<Books> allBooksOfSpecificAuthor();
}
