package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.SearchWordDto;
import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GenreController {

    BookService bookService;

    @Autowired
    public GenreController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults() {
        return new ArrayList<>();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @GetMapping(value = {"/genre", "/genre/{genre}"})
    public String getBooksByGenre(@PathVariable(value = "genre") String genre,
                                  @RequestParam(value = "offset", required = false) Integer offset,
                                  @RequestParam(value = "limit", required = false) Integer limit,
                                  Model model) {
        model.addAttribute("booksByGenre", bookService.getBooksByGenre(genre, offset, limit));
        return "/genres/slug";
    }

}
