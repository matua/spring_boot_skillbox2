package com.example.mybookshopapp2.respository;

import com.example.mybookshopapp2.model.BookRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRating, Integer> {

}