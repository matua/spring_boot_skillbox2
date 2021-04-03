package com.example.mybookshopapp2.data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class BookReviewLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer reviewId;
    private Integer userId;
    private LocalDateTime dateTime;
    private Byte value;

    public Integer getId() {
        return id;
    }

    public BookReviewLike setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public BookReviewLike setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public BookReviewLike setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public BookReviewLike setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Byte getValue() {
        return value;
    }

    public BookReviewLike setValue(Byte value) {
        this.value = value;
        return this;
    }
}
