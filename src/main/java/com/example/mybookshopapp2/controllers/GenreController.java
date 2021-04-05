package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.Author;
import com.example.mybookshopapp2.data.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

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
