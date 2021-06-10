package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GenreController {

    BookService bookService;

    @Autowired
    public GenreController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"/genre", "/genre/{genre}"})
    public String getBooksByGenre(@PathVariable(value = "genre") String genre,
                                  Model model) {
        model.addAttribute("booksByGenre", bookService.getPageOfBooksByGenre(genre, 0, 20));
        model.addAttribute("genre", genre);
        return "/genres/slug";
    }

}
