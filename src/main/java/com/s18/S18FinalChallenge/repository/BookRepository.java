package com.s18.S18FinalChallenge.repository;

import com.s18.S18FinalChallenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
