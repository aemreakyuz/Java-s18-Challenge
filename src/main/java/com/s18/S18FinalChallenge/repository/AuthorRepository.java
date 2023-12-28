package com.s18.S18FinalChallenge.repository;

import com.s18.S18FinalChallenge.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AuthorRepository extends JpaRepository<Author, Long> {
}
