package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.BooksPageDto;
import com.example.mybookshopapp2.data.SearchWordDto;
import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.service.BookService;
import com.example.mybookshopapp2.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.example.mybookshopapp2.utils.JsToDataSqlConverter.convert;

@Controller
public class MainPageController {

    private final BookService bookService;
    private final TagService tagService;

    @Autowired
    public MainPageController(BookService bookService, TagService tagService) {
        this.bookService = bookService;
        this.tagService = tagService;
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
    public String mainPage(Model model) {
        model.addAttribute("recommendedBooks", bookService.getPageOfRecommendedBooks(0, 6).getContent());
        model.addAttribute("recentBooks", bookService.getPageOfRecentBooks(0, 6).getContent());
        model.addAttribute("popularBooks", bookService.getPageOfPopularBooks(0, 6).getContent());
        model.addAttribute("tags", tagService.getAllTags());
        return "index";
    }

    @GetMapping(value = {
            "/books/recommended",
            "/books/recent",
            "/books/popular",
            "/books/genre/{genre}",
            "/books/tags/{tag}",
            "/books/author/{author}"
    })
    @ResponseBody
    public BooksPageDto getBooksPage(@PathVariable(value = "genre", required = false) String genre,
                                     @PathVariable(value = "tag", required = false) String tag,
                                     @PathVariable(value = "author", required = false) String author,
                                     @RequestParam("offset") Integer offset,
                                     @RequestParam("limit") Integer limit,
                                     @RequestParam(value = "from", required = false) String from,
                                     @RequestParam(value = "to", required = false) String to,
                                     HttpServletRequest request) {
        String path = request.getServletPath();
        if (path.contains("recommended")) {
            return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset, limit).getContent());
        } else if ((path.contains("recent"))) {
            return new BooksPageDto(bookService.getPageOfBooksFilteredByDate(offset, limit, convert(from), convert(to)).getContent());
        } else if ((path.contains("popular"))) {
            return new BooksPageDto(bookService.getPageOfPopularBooks(offset, limit).getContent());
        } else if ((path.contains("genre"))) {
            return new BooksPageDto(bookService.getPageOfBooksByGenre(genre, offset, limit).getContent());
        } else if ((path.contains("author"))) {
            return new BooksPageDto(bookService.getPageOfBooksByTag(tag, offset, limit).getContent());
        } else {
            return new BooksPageDto(bookService.getPageOfBooksByAuthor(author, offset, limit).getContent());
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