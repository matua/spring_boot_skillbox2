package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.BookReviewLike;
import com.example.mybookshopapp2.respository.BookReviewLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReviewLikeService {
    BookReviewLikeRepository bookReviewLikeRepository;

    @Autowired
    public BookReviewLikeService(BookReviewLikeRepository bookReviewLikeRepository) {
        this.bookReviewLikeRepository = bookReviewLikeRepository;
    }

    public void save(BookReviewLike bookReviewLike) {
        bookReviewLikeRepository.save(bookReviewLike);
    }
}
