package com.softuni.springintroex.engine;

import com.softuni.springintroex.service.AuthorService;
import com.softuni.springintroex.service.BookService;
import com.softuni.springintroex.service.CategoryService;
import com.softuni.springintroex.service.models.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


@Component
public class Engine implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;


    @Autowired
    public Engine(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {


        // seeData();  IMPORTANT  USE IF THE DB IS EMPTY !!!
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of ex. to check: ");
        int exNum = Integer.parseInt(reader.readLine());


        switch (exNum) {

            case 1:
                this.bookService.printAllBooksByAgeRes(reader.readLine());
                break;
            case 2:
                this.bookService.printAllBooksByEditionTypeAndCopies();
                break;
            case 3:
                this.bookService.printAllBookByPrice();
                break;
            case 4:
                this.bookService.printAllBooksNotInYear(reader.readLine());
                break;
            case 5:
                this.bookService.printAllBooksBeforeDate(reader.readLine());
                break;
            case 6:
                this.authorService.printAllAuthorsEndWith(reader.readLine());
                break;
            case 7:
                this.bookService.printAllBooksThatContainGivenString(reader.readLine());
                break;
            case 8:
                this.bookService.printAllBooksAuthorStartWith(reader.readLine());
                break;
            case 9:
                this.bookService.printNumberOfBooksEx09(Integer.parseInt(reader.readLine()));
                break;
            case 10:
                this.authorService.printAllAuthorsByCopies();
                break;

            case 11:
                BookInfo bookInfo = this.bookService.findBookByTitle(reader.readLine());

                System.out.println(bookInfo.getTitle());
                System.out.println(bookInfo.getPrice());
                System.out.println(bookInfo.getCopies());
                break;

        }



    }

    void seeData() throws IOException {
        this.categoryService.seedCategoryInDb();
        this.authorService.seedAuthorsInDb();
        this.bookService.seedBooksInDb();
    }
}
