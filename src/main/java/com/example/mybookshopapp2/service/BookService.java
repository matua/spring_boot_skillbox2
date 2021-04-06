package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.model.Genre;
import com.example.mybookshopapp2.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByTag(Genre tag) {
        return bookRepository.getBooksByGenre(tag);
    }
}
