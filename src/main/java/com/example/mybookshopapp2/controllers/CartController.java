package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
