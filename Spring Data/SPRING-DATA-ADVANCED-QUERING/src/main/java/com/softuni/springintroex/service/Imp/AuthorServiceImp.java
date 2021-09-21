package com.softuni.springintroex.service.Imp;

import com.softuni.springintroex.constants.GlobalConstants;
import com.softuni.springintroex.domain.repositories.AuthorRepository;
import com.softuni.springintroex.entities.Author;
import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.service.AuthorService;


import com.softuni.springintroex.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AuthorServiceImp implements AuthorService {


    private  final FileUtil fileUtil;
    private final AuthorRepository authorRepository;

    public AuthorServiceImp(FileUtil fileUtil, AuthorRepository authorRepository) {
        this.fileUtil = fileUtil;
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthorsInDb() throws IOException {
        String [] lines = fileUtil.readFileContent(GlobalConstants.AUTHORS_FILE_PATH);

        for (String line : lines) {
            String [] tokens = line.split("\\s+");

            Author author = new Author(tokens[0],tokens[1]);

            this.authorRepository.saveAndFlush(author);
        }



    }

    @Override
    public void printAllAuthorsEndWith(String start) {
        this.authorRepository.findAllByFirstNameEndingWith(start)
                .forEach(a -> System.out.printf("%s %s%n",a.getFirstName(),a.getLastName()));
    }

    @Override
    public void printAllAuthorsByCopies() {

        List<Author> author = this.authorRepository.findAll();

        Map<String, Integer> authorCopies = new HashMap<>();

        author.forEach(a->{
            int copies = a.getBooks().stream().mapToInt(Book::getCopies).sum();

            authorCopies.put(a.getFirstName() + " " + a.getLastName(), copies);
        });

        authorCopies
                .entrySet()
                .stream()
                .sorted((f,s) -> Integer.compare(s.getValue(),f.getValue()))
                .forEach(a -> System.out.printf("%s %d%n", a.getKey(),a.getValue()));

    }
}
