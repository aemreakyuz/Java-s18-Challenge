package com.s18.S18FinalChallenge.controller;

import com.s18.S18FinalChallenge.dto.AuthorResponse;
import com.s18.S18FinalChallenge.dto.AuthorResponseWithBooks;
import com.s18.S18FinalChallenge.dto.BookResponse;
import com.s18.S18FinalChallenge.entity.Author;
import com.s18.S18FinalChallenge.entity.Book;
import com.s18.S18FinalChallenge.service.AuthorService;
import com.s18.S18FinalChallenge.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private  AuthorService authorService;

    private  BookService bookService;



    @PostMapping
    public Author save(@RequestBody Author author) {
        return authorService.save(author);
    }

    @PostMapping("/{bookId}")
    public AuthorResponseWithBooks save(@RequestBody Author author, @PathVariable long bookId) {
        Book foundBook = bookService.findById(bookId);
        author.addBook(foundBook);
        authorService.save(author);
        List<BookResponse> responseList = new ArrayList<>();
        for (Book authorBook : author.getBooks()) {
           responseList.add(new BookResponse(authorBook.getId(), authorBook.getName(), authorBook.getCategory().getName(),new AuthorResponse(author.getId(), author.getFirstName() + " " + author.getLastName())));
        }
        return new AuthorResponseWithBooks(responseList);
    }

}
