package com.example.springdataintro.service.Imp;

import com.example.springdataintro.constans.GlobalConstants;
import com.example.springdataintro.entities.Category;
import com.example.springdataintro.repositories.CategoryRepository;
import com.example.springdataintro.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class CategoryService implements com.example.springdataintro.service.CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    public CategoryService(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedCategories() throws IOException {
        if(this.categoryRepository.count() != 0){
            return;
        }

        String [] fileContent =
                this.fileUtil.readFileContent(GlobalConstants.CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r ->  {
                    Category category = new Category(r);

                    this.categoryRepository.saveAndFlush(category);


                });
    }

    @Override
    public Category getCategory(Long id) {
        return this.categoryRepository.getOne(id);
    }
}
