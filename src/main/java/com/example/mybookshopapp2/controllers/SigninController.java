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
public class SigninController {

    private final AuthorService authorService;

    @Autowired
    public SigninController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        Map<String, List<Author>> authorsMap = authorService.getAuthorsMap();
        return authorService.getAuthorsMap();
    }

    @GetMapping("/signin")
    public String signinPage() {
        return "/signin";
    }

}
