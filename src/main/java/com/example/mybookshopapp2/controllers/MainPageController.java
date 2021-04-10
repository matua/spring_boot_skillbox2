package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.BooksPageDto;
import com.example.mybookshopapp2.data.SearchWordDto;
import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        bookService.getBooksData().forEach(book -> System.out.println(book.getAuthors()));
        return bookService.getPageOfRecommendedBooks(0, 6).getContent();
    }

    @ModelAttribute("recentBooks")
    public List<Book> recentBooks() {
        bookService.getBooksData().forEach(book -> System.out.println(book.getAuthors()));
        return bookService.getPageOfRecommendedBooks(6, 6).getContent();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks() {
        bookService.getBooksData().forEach(book -> System.out.println(book.getAuthors()));
        return bookService.getPageOfRecommendedBooks(18, 6).getContent();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults() {
        return new ArrayList<>();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getBooksPage(@RequestParam("offset") Integer offset,
                                     @RequestParam("limit") Integer limit, HttpServletRequest request) {
        String path = request.getServletPath();
        if (path.contains("recommended")) {
            return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset, limit).getContent());
        } else if ((path.contains("new"))) {
            return new BooksPageDto(bookService.getPageOfRecentBooks(offset, limit).getContent());
        } else {
            return new BooksPageDto(bookService.getPageOfPopularBooks(offset, limit).getContent());
        }
    }

    @GetMapping(value = {"/search", "/search/{searchWord}"})
    public String getSearchResults(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                   Model model) {
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("searchResults", bookService.getPageOfSearchResultBooks(
                searchWordDto.getExample(), 0, 5).getContent());
        return "/search/index";
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit,
                                          @PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto) {
        return new BooksPageDto(bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), offset, limit).getContent());
    }
}