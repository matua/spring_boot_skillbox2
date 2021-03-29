package com.example.mybookshopapp2.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBookData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) -> new Book()
                .setId(rs.getInt("id"))
                .setAuthor(getAuthorByAuthorId(rs.getInt("author_id")))
                .setTitle(rs.getString("title"))
                .setPriceOld(rs.getString("price_old"))
                .setPrice(rs.getString("price")));
        return new ArrayList<>(books);
    }

    private String getAuthorByAuthorId(int author_id) {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors WHERE authors.id=" + author_id, (ResultSet rs, int rowNum) -> new Author()
                .setId(rs.getInt("id"))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name")));
        return authors.get(0).toString();
    }
}
