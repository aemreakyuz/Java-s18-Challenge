package com.s18.S18FinalChallenge.service;

import com.s18.S18FinalChallenge.entity.Author;

public interface AuthorService {
    Author findById(long id);
    Author save(Author author);
}
