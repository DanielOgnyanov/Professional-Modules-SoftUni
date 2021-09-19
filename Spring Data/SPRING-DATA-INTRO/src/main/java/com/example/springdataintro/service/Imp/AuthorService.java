package com.example.springdataintro.service.Imp;


import com.example.springdataintro.constans.GlobalConstants;
import com.example.springdataintro.entities.Author;
import com.example.springdataintro.repositories.AuthorRepository;
import com.example.springdataintro.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService implements com.example.springdataintro.service.AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {

        if(this.authorRepository.count() != 0){
            return;
        }


        String [] fileContent = this.fileUtil
                .readFileContent(GlobalConstants.AUTHORS_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r ->  {

                    String[] params = r.split("\\s+");
                    Author author = new Author(params[0], params[1]);

                    this.authorRepository.saveAndFlush(author);

                });

    }

    @Override
    public int getAllAuthors() {
        return  (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public List<Author> findAllAuthorsByCountOfBooks() {
        return this.authorRepository.findAuthorBuCountOfBooks();
    }
}
