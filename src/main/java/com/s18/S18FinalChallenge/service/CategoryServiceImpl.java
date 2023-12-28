package com.s18.S18FinalChallenge.service;

import com.s18.S18FinalChallenge.entity.Category;
import com.s18.S18FinalChallenge.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            return categoryOptional.get();
        }
        throw new RuntimeException("Category Not Found");
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
