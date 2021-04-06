package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.BookReview;
import com.example.mybookshopapp2.respository.BookReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReviewService {
    private final BookReviewRepository bookReviewRepository;

    @Autowired
    public BookReviewService(BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }

    public List<BookReview> getAllBookReviews() {
        return bookReviewRepository.findAll();
    }
}
