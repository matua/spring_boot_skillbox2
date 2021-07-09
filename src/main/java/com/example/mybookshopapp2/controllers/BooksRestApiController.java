package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.ApiResponse;
import com.example.mybookshopapp2.errs.BookstoreApiWrongParameterException;
import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/books")
//@Api(description = "book data api")
public class BooksRestApiController {

    private final BookService bookService;

    @Autowired
    public BooksRestApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/{bookId}")
    public RepresentationModel<Book> getBookById(@PathVariable Integer bookId) {
        return bookService.getBookById(bookId)
                .add(
                        linkTo(
                                methodOn(BooksRestApiController.class)
                                        .getBestSellerBooks())
                                .withSelfRel());
    }

    @GetMapping(value = "/by-author-first-name", produces = "application/hal+json")
    @ApiOperation("operation to get book list of bookshop by author")
    public CollectionModel<Book> getBooksByAuthorFirstName(@RequestParam("author") String authorName) {

        List<Book> booksByAuthor = bookService.getBooksByAuthorFirstName(authorName);
        booksByAuthor.forEach(book -> {
            book.add(
                    linkTo(
                            methodOn(BooksRestApiController.class)
                                    .getBookById(book.getId()))
                            .withSelfRel());
        });
        return CollectionModel.of(booksByAuthor);
    }

    @GetMapping("/by-title")
    @ApiOperation("get books by book title")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request"),

    })
    public RepresentationModel<?> getBooksByTitle(@RequestParam("title") String title) throws BookstoreApiWrongParameterException {
        ApiResponse<Book> response = new ApiResponse<>();
        List<Book> data = bookService.getBooksByTitle(title);
        data.forEach(book -> {
            book.add(
                    linkTo(
                            methodOn(BooksRestApiController.class)
                                    .getBookById(book.getId()))
                            .withSelfRel());
        });
        response.setDebugMessage("successful request");
        response.setMessage("data size: " + data.size() + " elements");
        response.setStatus(HttpStatus.OK);
        response.setTimeStamp(LocalDateTime.now());
        response.setData(data);
        return RepresentationModel.of(ResponseEntity.ok(response));
    }

    @GetMapping("/by-price-range")
    @ApiOperation("get books by price range from min price to max price")
    public ResponseEntity<List<Book>> getBooksByPriceRange(@RequestParam("min") Integer min, @RequestParam("max") Integer max) {
        return ResponseEntity.ok(bookService.getBooksWithPriceBetween(min, max));
    }

    @GetMapping("/by-max-discount")
    @ApiOperation("get list of books with max price")
    public ResponseEntity<List<Book>> getBooksByMaxPrice() {
        return ResponseEntity.ok(bookService.getBooksWithMaxPrice());
    }

    @GetMapping("/bestsellers")
    @ApiOperation("get bestsellers (which is_bestseller = 1")
    public CollectionModel<Book> getBestSellerBooks() {
        List<Book> bestSellers = bookService.getBestsellers();
        bestSellers.forEach(book -> {
            book.add(
                    linkTo(
                            methodOn(BooksRestApiController.class)
                                    .getBookById(book.getId()))
                            .withSelfRel());
        });
        return CollectionModel.of(bestSellers);
    }
}