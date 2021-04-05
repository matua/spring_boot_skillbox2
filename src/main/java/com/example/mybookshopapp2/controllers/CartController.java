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
public class CartController {

    private final AuthorService authorService;

    @Autowired
    public CartController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "/cart";
    }

}
