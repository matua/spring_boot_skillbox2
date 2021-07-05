package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.example.mybookshopapp2.utils.TodayOneMonthAgoInDataSql.getDates;

@Controller
public class RecentController {

    Logger logger = LoggerFactory.getLogger(RecentController.class);

    private final BookService bookService;

    @Autowired
    public RecentController(BookService bookService) {
        this.bookService = bookService;
    }


    @ModelAttribute("recentBooks")
    @ResponseBody
    public List<Book> recentBooks() {
        return bookService.getPageOfBooksFilteredByDate(0, 20, getDates()[0], getDates()[1]).getContent();
    }

    @GetMapping("/recent")
    public String recentPage(Model model) {
        model.addAttribute("recentBooks", bookService.getPageOfRecentBooks(0, 20).getContent());
        logger.debug("Rendering /books/recent.html");
        return "books/recent";
    }
}