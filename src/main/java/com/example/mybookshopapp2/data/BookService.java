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
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) -> {
            return new Book()
                    .setId(rs.getInt("id"))
                    .setAuthor(rs.getString("author"))
                    .setTitle(rs.getString("title"))
                    .setPriceOld(rs.getString("priceOld"))
                    .setPrice(rs.getString("price"));
        });
        return new ArrayList<>(books);
    }
}
