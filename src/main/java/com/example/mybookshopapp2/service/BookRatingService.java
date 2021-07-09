package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.BookRating;
import com.example.mybookshopapp2.respository.BookRatingRepository;
import com.example.mybookshopapp2.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookRatingService {
    private final BookRatingRepository bookRatingRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookRatingService(BookRatingRepository bookRatingRepository, BookRepository bookRepository) {
        this.bookRatingRepository = bookRatingRepository;
        this.bookRepository = bookRepository;
    }

    public Map<Byte, Long> getBookRatingMap(String bookSlug) {
        List<BookRating> bookRatingMap = bookRatingRepository.findAllByBookId(
                getBookIdByBookSlug(bookSlug));
        return bookRatingMap
                .stream()
                .collect(Collectors.groupingBy(BookRating::getRating, Collectors.counting()));
    }

    public long getAverageRating(String bookSlug) {
        return Math.round(bookRatingRepository.findAllByBookId(getBookIdByBookSlug(bookSlug))
                .stream()
                .mapToInt(BookRating::getRating)
                .average()
                .orElse(0));
    }

    public Integer getTotalNumberOfRatingsByBook(String bookSlug) {
        return bookRatingRepository.findAllByBookId(getBookIdByBookSlug(bookSlug)).size();
    }

    public void save(BookRating bookRating) {
        bookRatingRepository.save(bookRating);
    }

    private Integer getBookIdByBookSlug(String bookSlug) {
        return bookRepository.findBookBySlug(bookSlug).getId();
    }
}