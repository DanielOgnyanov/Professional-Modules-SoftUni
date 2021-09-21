package com.softuni.springintroex.service;

import com.softuni.springintroex.service.models.BookInfo;

import java.awt.print.Book;
import java.io.IOException;

public interface BookService {
    void seedBooksInDb() throws IOException;
    void printAllBooksByAgeRes(String AgeRes);
    void printAllBooksByEditionTypeAndCopies();
    void printAllBookByPrice();
    void printAllBooksNotInYear(String year);
    void printAllBooksBeforeDate(String date);
    void printAllBooksAuthorStartWith(String start);
    void printNumberOfBooksEx09(int length);
    BookInfo findBookByTitle(String title);
    void printAllBooksThatContainGivenString(String contString);
}
