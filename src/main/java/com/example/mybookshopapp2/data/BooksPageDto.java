package com.example.mybookshopapp2.data;

import com.example.mybookshopapp2.model.Book;
import lombok.Data;

import java.util.List;

@Data
public class BooksPageDto {
    private Integer count;
    private List<Book> books;

    public BooksPageDto(List<Book> books) {
        this.books = books;
        this.count = books.size();
    }
}
