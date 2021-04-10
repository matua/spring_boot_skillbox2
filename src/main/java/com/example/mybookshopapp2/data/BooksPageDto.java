package com.example.mybookshopapp2.data;

import com.example.mybookshopapp2.model.Book;

import java.util.List;

public class BooksPageDto {
    private Integer count;
    private List<Book> books;

    public BooksPageDto(List<Book> books) {
        this.books = books;
        this.count = books.size();
    }

    public Integer getCount() {
        return count;
    }

    public BooksPageDto setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public BooksPageDto setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}
