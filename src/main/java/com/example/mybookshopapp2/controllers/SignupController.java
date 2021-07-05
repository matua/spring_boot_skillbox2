package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.model.Author;
import com.example.mybookshopapp2.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class SignupController {

    Logger logger = LoggerFactory.getLogger(SignupController.class);

    private final AuthorService authorService;

    @Autowired
    public SignupController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        Map<String, List<Author>> authorsMap = authorService.getAuthorsMap();
        return authorService.getAuthorsMap();
    }

    @GetMapping("/signup")
    public String signupPage() {
        logger.debug("Rendering signup.html");
        return "/signup";
    }

}
