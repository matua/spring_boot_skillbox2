package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.model.Tag;
import com.example.mybookshopapp2.service.BookService;
import com.example.mybookshopapp2.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TagsController {

    private final TagService tagService;
    private final BookService bookService;

    public TagsController(TagService tagService, BookService bookService) {
        this.tagService = tagService;
        this.bookService = bookService;
    }

    @ModelAttribute("tags")
    public List<Tag> mainGenres() {
        return tagService.getAllTags();
    }

    @GetMapping(value = {"/tags", "/tags/{tag}"})
    public String getBooksByGenre(@PathVariable(value = "tag") String tag,
                                  Model model) {
        model.addAttribute("booksByTag", bookService.getPageOfBooksByTag(tag, 0, 20));
        model.addAttribute("tag", tagService.getTagBySlug(tag));
        return "/tags/index";
    }
}
