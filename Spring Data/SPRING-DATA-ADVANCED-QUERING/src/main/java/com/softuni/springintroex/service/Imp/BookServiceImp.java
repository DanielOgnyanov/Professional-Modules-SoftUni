package com.softuni.springintroex.service.Imp;

import com.softuni.springintroex.constants.GlobalConstants;
import com.softuni.springintroex.domain.repositories.AuthorRepository;
import com.softuni.springintroex.domain.repositories.BookRepository;
import com.softuni.springintroex.domain.repositories.CategoryRepository;
import com.softuni.springintroex.entities.*;
import com.softuni.springintroex.service.BookService;
import com.softuni.springintroex.service.models.BookInfo;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;


@Service
public class BookServiceImp implements BookService {



    private final FileUtil fileUtil;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImp(FileUtil fileUtil, BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.fileUtil = fileUtil;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }





    @Override
    @Transactional
    public void seedBooksInDb() throws IOException {
        String [] lines = this.fileUtil.readFileContent(GlobalConstants.BOOKS_FILE_PATH);

        Random random = new Random();


        for (String line : lines) {
            String [] tokens = line.split("\\s+");

            long authorIndex = random.nextInt((int) this.authorRepository.count())+1;
            Author author = this.authorRepository.findById(authorIndex).get();
            EditionType editionType = EditionType.values()[Integer.parseInt(tokens[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate localDate = LocalDate.parse(tokens[1], formatter);
            int copies = Integer.parseInt(tokens[2]);
            BigDecimal price = new BigDecimal(tokens[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(tokens[4])];
            StringBuilder titleBuilder = new StringBuilder();


            for (int i = 5; i < tokens.length; i++) {
                titleBuilder.append(tokens[i]).append(" ");
            }
            String title = titleBuilder.toString().trim();

            Book book = new Book();



            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(localDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(this.getRandomCategories());

            bookRepository.saveAndFlush(book);




        }

    }

    @Override
    public void printAllBooksByAgeRes(String ageRes) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRes.toUpperCase(Locale.ROOT));

        this.bookRepository.findAllByAgeRestriction(ageRestriction)
        .forEach(b-> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllBooksByEditionTypeAndCopies() {
        this.bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD,5000)
                .forEach(b-> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllBookByPrice() {

        this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(b -> System.out.printf("%s - %s%n",b.getTitle(),b.getPrice()));
    }

    @Override
    public void printAllBooksNotInYear(String year) {
        this.bookRepository.findAllByRealiseDateNotInYear(year)
                .forEach(b-> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllBooksBeforeDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, dtf);

        this.bookRepository.findAllByReleaseDateIsLessThan(localDate)
                .forEach(b-> System.out.printf("%s %s %s%n",b.getTitle(),b.getEditionType(),b.getPrice()));
    }

    @Override
    public void printAllBooksAuthorStartWith(String start) {
        this.bookRepository.findAllByAuthorLastNameStartingWith(start)
                .forEach(b -> System.out.printf("%s (%s %s)%n",
                        b.getTitle(),
                        b.getAuthor().getFirstName(),
                        b.getAuthor().getLastName()));
    }

    @Override
    public void printNumberOfBooksEx09(int length) {
        System.out.println(this.bookRepository.getNumberOfBooksWithTitleLength(length));
    }

    @Override
    public BookInfo findBookByTitle(String title) {

        Book book = this.bookRepository.findAllByTitle(title);
        BookInfo bookInfo = new BookInfo(book.getTitle(),book.getPrice(),book.getCopies());

        return bookInfo;
    }

    @Override
    public void printAllBooksThatContainGivenString(String contString) {
        this.bookRepository.findAllByTitleContaining(contString)
                .forEach( b -> System.out.printf("%s%n",b.getTitle()));
    }

    Set<Category> getRandomCategories () {

        Set<Category> categories = new HashSet<>();

        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            long categoryIndex = random.nextInt((int) this.categoryRepository.count()) + 1;
            Category category = this.categoryRepository.findById(categoryIndex).get();

            categories.add(category);
        }

        return categories;
    }
}
