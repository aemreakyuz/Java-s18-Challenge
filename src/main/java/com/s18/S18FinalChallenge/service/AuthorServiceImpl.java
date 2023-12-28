package com.s18.S18FinalChallenge.service;

import com.s18.S18FinalChallenge.entity.Author;
import com.s18.S18FinalChallenge.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;




    @Override
    public Author findById(long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }

        throw new RuntimeException("Author does not exist. Id: " + id );
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}

