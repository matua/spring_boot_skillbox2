package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.Genre;
import com.example.mybookshopapp2.respository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getALlGenres() {
        return genreRepository.findAll();
    }

    public List<Genre> getAllMainGenres() {
        return genreRepository.findGenresByParentIdEquals(null);
    }

//    public Map<Integer, List<Genre>> getGenresMap() {
//        Map<Integer, List<Genre>> collect = genreRepository.findAll().stream()
//                .collect(Collectors.groupingBy(Genre::getParentId));
//        collect.forEach((k, listOfGroupedChildren) -> {
//            System.out.println(k + ":");
//            for(Genre genre : listOfGroupedChildren){
//                System.out.println(genre.getName());
//            }
//        });
//        return collect;
//    }

    public Map<Integer, List<Genre>> getGenresMap() {
        Map<Integer, List<Genre>> collect = genreRepository.findAll().stream()
                .collect(Collectors.groupingBy(Genre::getParentId));
        collect.forEach((k, listOfGroupedChildren) -> {
            System.out.println(k + ":");
            for (Genre genre : listOfGroupedChildren) {
                System.out.println(genre.getName());
            }
        });
        return collect;
    }
}
