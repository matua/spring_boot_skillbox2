package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.Author;
import com.example.mybookshopapp2.respository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        return authorRepository.findAll().stream().collect(Collectors.groupingBy((Author a) -> a.getLastName().substring(0, 1)));
    }

    public Author getAuthorByName(String firstName, String lastName) {
        return authorRepository.getAuthorByFirstNameOrLastName(firstName, lastName);
    }

    public Author getAuthorBySlug(String author) {
        return authorRepository.findAuthorBySlug(author);
    }
}
