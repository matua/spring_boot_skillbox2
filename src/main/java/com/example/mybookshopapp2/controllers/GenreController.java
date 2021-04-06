package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenreController {

    private final AuthorService authorService;

    @Autowired
    public GenreController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/genre")
    public String genresPage() {
        return "/genres/slug";
    }

}
