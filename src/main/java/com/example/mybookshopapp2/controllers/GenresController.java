package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.Genre;
import com.example.mybookshopapp2.data.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class GenresController {

    private final GenreService genreService;

    @Autowired
    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @ModelAttribute("genres")
    public List<Genre> genres() {
        return genreService.getALlGenres();
    }

    @GetMapping("/genres")
    public String genresPage() {
        return "/genres/index";
    }

}
