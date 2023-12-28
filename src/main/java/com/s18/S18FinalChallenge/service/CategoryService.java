package com.s18.S18FinalChallenge.service;

import com.s18.S18FinalChallenge.entity.Category;

public interface CategoryService {
    Category findById(long id);
    Category save(Category category);
}
