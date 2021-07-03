package com.example.mybookshopapp2.respository;

import com.example.mybookshopapp2.model.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {

    List<BookReview> findAllByBookId(Integer bookId);
}
