package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.Genre;
import com.example.mybookshopapp2.respository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllMainGenres() {
        return genreRepository.findGenresByParentIdEquals(null);
    }

    public Map<Genre, List<Genre>> getGenresMap() {
        Map<Integer, Genre> ids = genreRepository.findAll().stream()
                .collect(Collectors.toMap(Genre::getId, Function.identity()));

        return genreRepository.findAll().stream()
                .collect(Collectors.groupingBy(genre -> Optional.ofNullable(ids.get(genre.getParentId())).orElse(genre)));
    }
}