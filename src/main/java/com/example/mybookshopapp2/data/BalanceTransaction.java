package com.example.mybookshopapp2.data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class BalanceTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private LocalDateTime time;
    private BigDecimal value;
    private Integer bookId;
    private String description;

    public Integer getId() {
        return id;
    }

    public BalanceTransaction setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public BalanceTransaction setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public BalanceTransaction setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BalanceTransaction setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public Integer getBookId() {
        return bookId;
    }

    public BalanceTransaction setBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BalanceTransaction setDescription(String description) {
        this.description = description;
        return this;
    }
}