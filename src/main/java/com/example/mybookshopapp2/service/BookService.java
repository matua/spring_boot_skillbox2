package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

//    public List<Book> getBooksByTag(Genre tag) {
//        return bookRepository.getBooksByGenre(tag);
//    }

    public List<Book> getBooksByAuthor(String authorName) {
        return bookRepository.findBookByAuthorsFirstNameContaining(authorName);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findBookByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max) {
        return bookRepository.findBooksByPriceOldBetween(min, max);
    }

    public List<Book> getBooksWithPrice(Integer price) {
        return bookRepository.findBooksByPriceOldIs(price);
    }

    public List<Book> getBooksWithMaxPrice() {
        return bookRepository.getBooksWithMaxDiscount();
    }

    public List<Book> getBestsellers() {
        return bookRepository.getBestsellers();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findBooksByTitleContaining(searchWord, nextPage);
    }

    public Page<Book> getPageOfRecentBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("pubDate").descending());
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit) {
        /*TODO*/
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfBooksFilteredByDate(Integer offset, Integer limit, Date from, Date to) {
        Pageable nextPage = PageRequest.of(offset, limit);
//        if (from == null && to == null) {
//            return bookRepository.findAll(nextPage);
//        }
        return bookRepository.findByPubDateBetween(from, to, nextPage);
    }
}
