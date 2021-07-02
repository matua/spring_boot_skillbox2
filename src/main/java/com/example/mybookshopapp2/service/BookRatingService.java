package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.respository.BookRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRatingService {
    private final BookRatingRepository bookRatingRepository;

    @Autowired
    public BookRatingService(BookRatingRepository bookRatingRepository) {
        this.bookRatingRepository = bookRatingRepository;
    }
}