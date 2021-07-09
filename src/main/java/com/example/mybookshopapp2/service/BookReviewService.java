package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.BookReview;
import com.example.mybookshopapp2.respository.BookRepository;
import com.example.mybookshopapp2.respository.BookReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReviewService {
    private final BookReviewRepository bookReviewRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookReviewService(BookReviewRepository bookReviewRepository, BookRepository bookRepository) {
        this.bookReviewRepository = bookReviewRepository;
        this.bookRepository = bookRepository;
    }

    public void postReview(BookReview bookReview) {
        bookReviewRepository.save(bookReview);
    }

    public List<BookReview> getBookReviewsByBookId(String bookSlug) {
        return bookReviewRepository.findAllByBookId(getBookIdByBookSlug(bookSlug));
    }

    public Integer getTotalNumberOfReviewsByBook(String bookSlug) {
        return bookReviewRepository.findAllByBookId(getBookIdByBookSlug(bookSlug)).size();
    }

    public BookReview getBookReviewById(String bookReviewId) {
        return bookReviewRepository.getOne(Integer.valueOf(bookReviewId));
    }

    private Integer getBookIdByBookSlug(String bookSlug) {
        return bookRepository.findBookBySlug(bookSlug).getId();
    }
}