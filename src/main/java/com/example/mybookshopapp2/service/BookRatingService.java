package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.BookRating;
import com.example.mybookshopapp2.respository.BookRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookRatingService {
    private final BookRatingRepository bookRatingRepository;

    @Autowired
    public BookRatingService(BookRatingRepository bookRatingRepository) {
        this.bookRatingRepository = bookRatingRepository;
    }

    public Map<Byte, Long> getBookRatingMap(Integer bookId) {
        List<BookRating> bookRatingMap = bookRatingRepository.findAllByBookId(bookId);
        return bookRatingMap
                .stream()
                .collect(Collectors.groupingBy(BookRating::getRating, Collectors.counting()));
    }

    public Integer getTotalNumberOfRatings(Integer bookId) {
        List<BookRating> bookRatingMap = bookRatingRepository.findAllByBookId(bookId);
        return  bookRatingMap.size();
    }

    public long getAverageRating(Integer bookId) {
        return Math.round(bookRatingRepository.findAllByBookId(bookId)
                .stream()
                .mapToInt(BookRating::getRating)
                .average()
                .orElse(0));
    }
}