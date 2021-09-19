package com.example.springdataintro.service.Imp;

import com.example.springdataintro.constans.GlobalConstants;
import com.example.springdataintro.entities.*;
import com.example.springdataintro.repositories.BookRepository;
import com.example.springdataintro.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
public class BookService implements com.example.springdataintro.service.BookService {


    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private  final  CategoryService categoryService;
    private final FileUtil fileUtil;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedBooks() throws IOException {
        if(this.bookRepository.count() != 0) {
            return;
        }

        String [] fileContent = this.fileUtil
                .readFileContent(GlobalConstants.BOOKS_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r ->  {

                    String [] params = r.split("\\s+");
                    Author author = this.getRandomAuthor();


                    EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate  realiseDate = LocalDate.parse(params[1], formatter);

                    int copies = Integer.parseInt(params[2]);


                    BigDecimal price = new BigDecimal(params[3]);


                    AgeRestriction ageRestriction = AgeRestriction
                            .values()[Integer.parseInt(params[4])];

                    String title = this.getTitle(params);

                    Set<Category> categories = this.getRandomCategories();


                    Books book = new Books();

                    book.setAuthor(author);
                    book.setEditionType(editionType);
                    book.setRealiseDate(realiseDate);
                    book.setCopies(copies);
                    book.setPrice(price);
                    book.setAgeRestriction(ageRestriction);
                    book.setTitle(title);
                    book.setCategories(categories);

                    this.bookRepository.saveAndFlush(book);


                });
    }

    @Override
    public List<Books> getAllBooksAfter2000() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate realiseDate1 = LocalDate.parse("31/12/2000",formatter);



        return this.bookRepository.findAllByRealiseDateAfter(realiseDate1);
    }

    @Override
    public List<Books> getAllNamesOfAuthorWithBookBefore1990() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate realiseDate2 = LocalDate.parse("01/01/1990",formatter);

        return this.bookRepository.findAllByRealiseDateBefore(realiseDate2);
    }

    @Override
    public List<Books> allBooksOfSpecificAuthor() {
        return this.bookRepository.allBooksOfSpecificAuthor();
    }

    private Set<Category> getRandomCategories() {

        Set<Category> result = new HashSet<>();

        Random random = new Random();

        int bound = random.nextInt(3) + 1;



        for (int i = 1; i <= bound; i++) {
            int categoryId = random.nextInt(8) + 1;

            result.add(this.categoryService.getCategory((long) categoryId));
        }



        return result;
    }

    private String getTitle(String[] params) {

        StringBuilder sb = new StringBuilder();

        for (int i = 5; i < params.length; i++) {

            sb.append(params[i]).append(" ");
        }

        return sb.toString().trim();
    }

    private Author getRandomAuthor() {

        Random random = new Random();

        int randomId = random.nextInt(this.authorService.getAllAuthors()) + 1;

        return this.authorService.findAuthorById((long) randomId);

    }
}
