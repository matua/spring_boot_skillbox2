package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.ResourceStorage;
import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.model.BookRating;
import com.example.mybookshopapp2.model.BookReview;
import com.example.mybookshopapp2.model.BookReviewLike;
import com.example.mybookshopapp2.service.BookRatingService;
import com.example.mybookshopapp2.service.BookReviewLikeService;
import com.example.mybookshopapp2.service.BookReviewService;
import com.example.mybookshopapp2.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

import static com.example.mybookshopapp2.temp.TestData.getTestUser;

@Controller
@RequestMapping("/books")
public class BooksController {

    Logger logger = LoggerFactory.getLogger(BooksController.class);

    private final BookRatingService bookRatingService;
    private final ResourceStorage storage;
    private final BookReviewService bookReviewService;
    private final BookReviewLikeService bookReviewLikeService;
    private final BookService bookService;

    @Autowired
    public BooksController(BookRatingService bookRatingService, ResourceStorage storage, BookReviewService bookReviewService, BookReviewLikeService bookReviewLikeService, BookService bookService) {
        this.bookRatingService = bookRatingService;
        this.storage = storage;
        this.bookReviewService = bookReviewService;
        this.bookReviewLikeService = bookReviewLikeService;
        this.bookService = bookService;
    }

    @PostMapping("/bookReview")
    public String postReview(@RequestParam String bookId,
                             @RequestParam String bookSlug,
                             @RequestParam String text) {
        BookReview bookReview = new BookReview();
        bookReview.setBookId(Integer.valueOf(bookId))
                .setTime(LocalDateTime.now())
                .setText(text)
                .setUser(getTestUser());
        bookReviewService.postReview(bookReview);
        logger.debug("Redirecting to and rendering /books/slug.html");
        return ("redirect:/books/" + bookSlug);
    }

    @GetMapping("/{slug}")
    public String getBookPage(@PathVariable("slug") String slug, Model model) {
        Book book = bookService.findBookBySlug(slug);
        model.addAttribute("slugBook", book);
        model.addAttribute("bookRatingMap", bookRatingService.getBookRatingMap(slug));
        model.addAttribute("bookAverageRating", bookRatingService.getAverageRating(slug));
        model.addAttribute("bookTotalNumberOfRatings", bookRatingService.getTotalNumberOfRatingsByBook(slug));
        model.addAttribute("bookTotalNumberOfReviewsByBook", bookReviewService.getTotalNumberOfReviewsByBook(slug));
        model.addAttribute("bookReviews", bookReviewService.getBookReviewsByBookId(slug));
        logger.debug("Rendering books/slug.html");
        return "/books/slug";
    }

    @PostMapping("/rate/{slug}")
    public String rateBook(@PathVariable("slug") String slug,
                           @RequestParam("value") String rating,
                           Model model) {
        Book book = bookService.findBookBySlug(slug);

        BookRating bookRating = new BookRating();
        bookRating.setRating(Byte.parseByte(rating))
                .setBook(book)
                .setTime(LocalDateTime.now());

        bookRatingService.save(bookRating);
        model.addAttribute("slugBook", book);
        logger.debug("Redirecting to and rendering /books/slug.html");
        return ("redirect:/books/" + slug);
    }

    @PostMapping("/rate/{slug}/rateBookReview")
    public String rateBookReview(
            @PathVariable("slug") String slug,
            @RequestParam("reviewid") String bookReviewId,
            @RequestParam("value") String likeDislike) {

        BookReviewLike bookReviewLike = new BookReviewLike();

        BookReview bookReview = bookReviewService.getBookReviewById(bookReviewId);
        bookReviewLike.setValue(Byte.valueOf(likeDislike))
                .setDateTime(LocalDateTime.now())
                .setReviewId(bookReview);

        bookReviewLikeService.save(bookReviewLike);
        logger.debug("Redirecting to and rendering /books/slug.html");
        return ("redirect:/books/" + slug);
    }

    @PostMapping("/{slug}/img/save")
    public String saveNewBookImage(@RequestParam("file") MultipartFile file,
                                   @PathVariable("slug") String slug) throws IOException {

        String savePath = storage.saveNewBookImage(file, slug);
        Book bookToUpdate = bookService.findBookBySlug(slug);
        bookToUpdate.setImage(savePath);
        bookService.save(bookToUpdate);
        logger.debug("Redirecting to and rendering /books/slug.html");
        return ("redirect:/books/" + slug);
    }


    @GetMapping("/download/{hash}")
    public ResponseEntity<ByteArrayResource> getBookFile(@PathVariable("hash") String hash) throws IOException {

        Path path = storage.getBookFilePath(hash);
        logger.info("book file path: " + path);

        MediaType mediaType = storage.getBookFileMime(hash);
        logger.info("book file mime type: " + mediaType);

        byte[] data = storage.getBookFileByteArray(hash);
        logger.info("book file data len: " + data.length);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + path.getFileName().toString())
                .contentType(mediaType)
                .contentLength(data.length)
                .body(new ByteArrayResource(data));
    }
}