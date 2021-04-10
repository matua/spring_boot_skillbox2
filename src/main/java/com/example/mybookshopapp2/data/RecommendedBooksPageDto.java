package com.example.mybookshopapp2.data;

import com.example.mybookshopapp2.model.Book;

import java.util.List;

public class RecommendedBooksPageDto {
    private Integer count;
    private List<Book> books;

    public RecommendedBooksPageDto(List<Book> books) {
        this.books = books;
        this.count = books.size();
    }

    public Integer getCount() {
        return count;
    }

    public RecommendedBooksPageDto setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public RecommendedBooksPageDto setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}
