package com.s18.S18FinalChallenge.service;

import com.s18.S18FinalChallenge.entity.Book;

public interface BookService {
    Book findById(long id);

    Book save(Book book);
}
