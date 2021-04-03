package com.example.mybookshopapp2.data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class FileDownload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public FileDownload setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public FileDownload setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getBookId() {
        return bookId;
    }

    public FileDownload setBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public FileDownload setCount(Integer count) {
        this.count = count;
        return this;
    }
}
