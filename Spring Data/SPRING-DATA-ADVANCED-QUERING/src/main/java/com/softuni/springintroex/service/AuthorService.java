package com.softuni.springintroex.service;

import java.io.IOException;

public interface AuthorService {
    void seedAuthorsInDb() throws IOException;
    void printAllAuthorsEndWith(String start);
    void printAllAuthorsByCopies();
}
