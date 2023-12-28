package com.s18.S18FinalChallenge.service;

import com.s18.S18FinalChallenge.entity.Book;
import com.s18.S18FinalChallenge.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        }
        throw new RuntimeException("Could not find book with Id: " + id);
    }



    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }
}
