package com.example.mybookshopapp2.respository;

import com.example.mybookshopapp2.model.BookRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRating, Integer> {

    List<BookRating> findAllByBookId(Integer bookId);
}