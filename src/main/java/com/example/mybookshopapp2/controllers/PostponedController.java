package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostponedController {

    private final AuthorService authorService;

    @Autowired
    public PostponedController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/postponed")
    public String postponedPage() {
        return "/postponed";
    }

}
