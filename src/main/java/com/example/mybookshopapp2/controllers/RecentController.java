package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.SearchWordDto;
import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

import static com.example.mybookshopapp2.utils.TodayOneMonthAgoInDataSql.getDates;

@Controller
public class RecentController {

    private final BookService bookService;

    @Autowired
    public RecentController(BookService bookService) {
        this.bookService = bookService;
    }


    @ModelAttribute("recentBooks")
    public List<Book> recentBooks() {
        return bookService.getPageOfBooksFilteredByDate(0, 20, getDates()[0], getDates()[1]).getContent();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults() {
        return new ArrayList<>();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @GetMapping("/recent")
    public String recentPage() {
        return "books/recent";
    }
}