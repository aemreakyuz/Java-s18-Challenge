package com.s18.S18FinalChallenge.controller;


import com.s18.S18FinalChallenge.dto.AuthorResponse;
import com.s18.S18FinalChallenge.dto.BookResponse;
import com.s18.S18FinalChallenge.entity.Author;
import com.s18.S18FinalChallenge.entity.Book;
import com.s18.S18FinalChallenge.entity.Category;
import com.s18.S18FinalChallenge.service.AuthorService;
import com.s18.S18FinalChallenge.service.BookService;
import com.s18.S18FinalChallenge.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private  BookService bookService;
    private  AuthorService authorService;
    private  CategoryService categoryService;

    @PostMapping("/{categoryId}")
    public BookResponse save (@RequestBody Book book, @PathVariable long categoryId){
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(), book.getCategory().getName(), null);
    }

    @PostMapping("/saveByAuthor")
    public BookResponse save (@RequestBody Book book, @RequestParam long categoryId, @RequestParam long authorId){
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
       Author author = authorService.findById(authorId);
       book.setAuthor(author);
       author.addBook(book);
       bookService.save(book);
        return new BookResponse(book.getId(), book.getName(), book.getCategory().getName(), new AuthorResponse(author.getId(), author.getFirstName() + " " + author.getLastName()));
    }
}
