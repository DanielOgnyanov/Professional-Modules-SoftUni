package com.example.springdataintro.controller;

import com.example.springdataintro.entities.Books;
import com.example.springdataintro.service.AuthorService;
import com.example.springdataintro.service.BookService;
import com.example.springdataintro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;


@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {

        this.categoryService.seedCategories();

        this.authorService.seedAuthors();;

        this.bookService.seedBooks();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ex. number to check it: ");

        int exNumToCheck = Integer.parseInt(scanner.nextLine());

        switch (exNumToCheck) {

            case 1:
                List<Books> booksList = this.bookService.getAllBooksAfter2000();
                break;

            case 2:
                this.bookService.getAllNamesOfAuthorWithBookBefore1990()
                        .forEach(b-> {
                            System.out.printf("%s %s%n", b.getAuthor().getFirstName(),
                                    b.getAuthor().getLastName());
                            System.out.println();
                        });

                break;

            case 3:
                this.authorService
                               .findAllAuthorsByCountOfBooks()
                               .forEach(a-> {
                                  System.out.printf("%s %s %d%n",
                                           a.getFirstName(),
                                          a.getLastName(),
                                            a.getBooks().size());
                               });

                break;

            case 4:
                this.bookService.allBooksOfSpecificAuthor()
                        .forEach(b -> {
                            System.out.printf("%s---%s---%d%n",
                                    b.getTitle(),
                                    b.getRealiseDate(),
                                    b.getCopies());
                        });
        }









    }
}
