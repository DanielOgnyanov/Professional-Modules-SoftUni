package com.softuni.springintroex.service.Imp;

import com.softuni.springintroex.constants.GlobalConstants;
import com.softuni.springintroex.domain.repositories.CategoryRepository;
import com.softuni.springintroex.entities.Category;
import com.softuni.springintroex.service.CategoryService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class CategoryServiceImp implements CategoryService {


    private final FileUtil fileUtil;
    private  final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(FileUtil fileUtil, CategoryRepository categoryRepository) {
        this.fileUtil = fileUtil;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategoryInDb() throws IOException {

        String [] lines = fileUtil.readFileContent(GlobalConstants.CATEGORIES_FILE_PATH);

        for (String line : lines) {
            Category category = new Category(line);
            this.categoryRepository.saveAndFlush(category);
        }



    }
}
