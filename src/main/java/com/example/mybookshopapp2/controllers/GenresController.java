package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.SearchWordDto;
import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.model.Genre;
import com.example.mybookshopapp2.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GenresController {

    private final GenreService genreService;

    @Autowired
    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @ModelAttribute("mainGenres")
    public List<Genre> mainGenres() {
        return genreService.getAllMainGenres();
    }

    @ModelAttribute("genresMap")
    public Map<Genre, List<Genre>> genres() {
        return genreService.getGenresMap();
    }

    @GetMapping("/genres")
    public String genresPage() {
        return "/genres/index";
    }

}
