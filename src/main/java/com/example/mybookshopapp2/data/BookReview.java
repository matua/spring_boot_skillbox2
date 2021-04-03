package com.example.mybookshopapp2.data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer bookId;
    private Integer userId;
    private LocalDateTime time;
    private String text;

    public Integer getId() {
        return id;
    }

    public BookReview setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getBookId() {
        return bookId;
    }

    public BookReview setBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public BookReview setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public BookReview setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public String getText() {
        return text;
    }

    public BookReview setText(String text) {
        this.text = text;
        return this;
    }
}
