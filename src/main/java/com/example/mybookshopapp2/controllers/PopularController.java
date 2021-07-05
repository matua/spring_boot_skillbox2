package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopularController {

    Logger logger = LoggerFactory.getLogger(PopularController.class);

    private final BookService bookService;

    @Autowired
    public PopularController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/popular")
    public String popularPage(Model model) {
        model.addAttribute("popularBooks", bookService.getPageOfPopularBooks(0, 20).getContent());
        logger.debug("Rendering books/popular.html");
        return "books/popular";
    }
}