package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.SearchWordDto;
import com.example.mybookshopapp2.model.Author;
import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.service.AuthorService;
import com.example.mybookshopapp2.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
//@Api(description = "authors data")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        Map<String, List<Author>> authorsMap = authorService.getAuthorsMap();
        return authorService.getAuthorsMap();
    }

    @ModelAttribute("author")
    public Author getAuthor(@PathVariable(value = "author", required = false) String author) {
        return authorService.getAuthorBySlug(author);
    }

    @ModelAttribute("booksByAuthor")
    public List<Book> getBooksByAuthor(@PathVariable(value = "author", required = false) String author) {
        return bookService.getPageOfBooksByAuthor(author, 0, 20).getContent();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults() {
        return new ArrayList<>();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @ApiOperation("method to get map of authors")
    @GetMapping("/api/authors")
    @ResponseBody
    public Map<String, List<Author>> authors() {
        return authorService.getAuthorsMap();
    }

    @GetMapping("/author/{author}")
    public String booksByAuthorPage() {
        return "books/author";
    }

    @GetMapping("/authors/{author}")
    public String authorPage() {
        return "authors/slug";
    }
}