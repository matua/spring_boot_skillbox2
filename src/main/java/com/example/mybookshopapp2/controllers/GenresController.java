package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.model.Genre;
import com.example.mybookshopapp2.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class GenresController {

    Logger logger = LoggerFactory.getLogger(GenresController.class);

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
        logger.debug("Rendering genres/index.html");
        return "/genres/index";
    }

}
