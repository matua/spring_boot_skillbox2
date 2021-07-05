package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.ResourceStorage;
import com.example.mybookshopapp2.model.*;
import com.example.mybookshopapp2.respository.BookRatingRepository;
import com.example.mybookshopapp2.respository.BookRepository;
import com.example.mybookshopapp2.service.BookRatingService;
import com.example.mybookshopapp2.service.BookReviewLikeService;
import com.example.mybookshopapp2.service.BookReviewService;
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
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookRepository bookRepository;
    private final BookRatingService bookRatingService;
    private final ResourceStorage storage;
    private final BookRatingRepository bookRatingRepository;
    private final BookReviewService bookReviewService;
    private final BookReviewLikeService bookReviewLikeService;

    @Autowired
    public BooksController(BookRepository bookRepository, BookRatingService bookRatingService, ResourceStorage storage, BookRatingRepository bookRatingRepository, BookReviewService bookReviewService, BookReviewLikeService bookReviewLikeService) {
        this.bookRepository = bookRepository;
        this.bookRatingService = bookRatingService;
        this.storage = storage;
        this.bookRatingRepository = bookRatingRepository;
        this.bookReviewService = bookReviewService;
        this.bookReviewLikeService = bookReviewLikeService;
    }

    @PostMapping("/bookReview")
    public String postReview(@RequestParam String bookId,
                             @RequestParam String bookSlug,
                             @RequestParam String text) {
        BookReview bookReview = new BookReview();
        User user = new User(); //temp for testing
        user.setId(5); //temp for testing
        user.setName("Jonathan Matua"); //temp for testing
        bookReview.setBookId(Integer.valueOf(bookId))
                .setTime(LocalDateTime.now())
                .setText(text)
                .setUser(user); //temp for testing
        bookReviewService.postReview(bookReview);
        return ("redirect:/books/" + bookSlug);
    }

    @GetMapping("/{slug}")
    public String bookPage(@PathVariable("slug") String slug, Model model) {
        Book book = bookRepository.findBookBySlug(slug);
        model.addAttribute("slugBook", book);
        model.addAttribute("bookRatingMap", bookRatingMap(slug));
        model.addAttribute("bookAverageRating", bookAverageRating(slug));
        model.addAttribute("bookTotalNumberOfRatings", getTotalNumberOfRatingsByBook(slug));
        model.addAttribute("bookTotalNumberOfReviewsByBook", getTotalNumberOfReviewsByBook(slug));
        model.addAttribute("bookReviews", getBookReviewsByBookId(slug));
        return "/books/slug";
    }

    @PostMapping("/rate/{slug}")
    public String rateBook(@PathVariable("slug") String slug,
                           @RequestParam("value") String rating,
                           Model model) {
        Book book = bookRepository.findBookBySlug(slug);

        BookRating bookRating = new BookRating();
        bookRating.setRating(Byte.parseByte(rating))
                .setBook(book)
                .setTime(LocalDateTime.now());

        bookRatingRepository.save(bookRating);
        model.addAttribute("slugBook", book);

        return ("redirect:/books/" + slug);
    }

    @PostMapping("/rate/{slug}/rateBookReview")
    public String rateBookReview(
            @PathVariable("slug") String slug,
            @RequestParam("reviewid") String bookReviewId,
            @RequestParam("value") String likeDislike,
            Model model) {

        BookReviewLike bookReviewLike = new BookReviewLike();

        BookReview bookReview = bookReviewService.getBookReviewById(bookReviewId);
        bookReviewLike.setValue(Byte.valueOf(likeDislike))
                .setDateTime(LocalDateTime.now())
                .setReviewId(bookReview);

        bookReviewLikeService.save(bookReviewLike);
        return ("redirect:/books/" + slug);
    }

    @PostMapping("/{slug}/img/save")
    public String saveNewBookImage(@RequestParam("file") MultipartFile file,
                                   @PathVariable("slug") String slug) throws IOException {

        String savePath = storage.saveNewBookImage(file, slug);
        Book bookToUpdate = bookRepository.findBookBySlug(slug);
        bookToUpdate.setImage(savePath);
        bookRepository.save(bookToUpdate);

        return ("redirect:/books/" + slug);
    }


    @GetMapping("/download/{hash}")
    public ResponseEntity<ByteArrayResource> bookFile(@PathVariable("hash") String hash) throws IOException {

        Path path = storage.getBookFilePath(hash);
        Logger.getLogger(this.getClass().getSimpleName()).info("book file path: " + path);

        MediaType mediaType = storage.getBookFileMime(hash);
        Logger.getLogger(this.getClass().getSimpleName()).info("book file mime type: " + mediaType);

        byte[] data = storage.getBookFileByteArray(hash);
        Logger.getLogger(this.getClass().getSimpleName()).info("book file data len: " + data.length);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + path.getFileName().toString())
                .contentType(mediaType)
                .contentLength(data.length)
                .body(new ByteArrayResource(data));
    }

    private Map<Byte, Long> bookRatingMap(@PathVariable String slug) {
        Integer bookId = bookRepository.findBookBySlug(slug).getId();
        return bookRatingService.getBookRatingMap(bookId);
    }

    private Long bookAverageRating(@PathVariable("slug") String slug) {
        Integer bookId = bookRepository.findBookBySlug(slug).getId();
        return bookRatingService.getAverageRating(bookId);
    }

    private Integer getTotalNumberOfRatingsByBook(@PathVariable("slug") String slug) {
        Integer bookId = bookRepository.findBookBySlug(slug).getId();
        return bookRatingService.getTotalNumberOfRatingsByBook(bookId);
    }

    private Integer getTotalNumberOfReviewsByBook(@PathVariable("slug") String slug) {
        Integer bookId = bookRepository.findBookBySlug(slug).getId();
        return bookReviewService.getTotalNumberOfReviewsByBook(bookId);
    }

    private List<BookReview> getBookReviewsByBookId(@PathVariable("slug") String slug) {
        Integer bookId = bookRepository.findBookBySlug(slug).getId();
        return bookReviewService.getBookReviewsByBookId(bookId);
    }
}