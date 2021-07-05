package com.example.mybookshopapp2.respository;

import com.example.mybookshopapp2.model.BookReviewLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReviewLikeRepository extends JpaRepository<BookReviewLike, Integer> {

    List<BookReviewLike> findAllByReviewId(Integer bookId);
}
