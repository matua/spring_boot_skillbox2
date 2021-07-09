package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.errs.BookstoreApiWrongParameterException;
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

    public List<Book> getBooksByAuthorFirstName(String authorName) {
        return bookRepository.findBookByAuthorsFirstNameContainingIgnoreCase(authorName);
    }

    public List<Book> getBooksByTitle(String title) throws BookstoreApiWrongParameterException {
        if (title.equals("") || title.length() <= 1) {
            throw new BookstoreApiWrongParameterException("Wrong values passed to one or more parameters");
        } else {
            List<Book> data = bookRepository.findBooksByTitleContaining(title);
            if (data.size() > 0) {
                return data;
            } else {
                throw new BookstoreApiWrongParameterException("No data found with specified parameters...");
            }
        }
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max) {
        return bookRepository.findBooksByPriceOldBetween(min, max);
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
        return bookRepository.findPageBooksByTitleLikeIgnoreCase(String.format("%%%s%%", searchWord), nextPage);
    }

    public Page<Book> getPageOfRecentBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("pubDate").descending());
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("rating").descending().and(Sort.by("pubDate")));
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfBooksFilteredByDate(Integer offset, Integer limit, Date from, Date to) {
        Pageable nextPage = PageRequest.of(offset, limit);
        if (from == null && to == null) {
            return bookRepository.findAll(nextPage);
        } else if (from == null) {
            return bookRepository.findByPubDateBefore(to, nextPage);
        } else if (to == null) {
            return bookRepository.findByPubDateAfter(from, nextPage);
        }
        return bookRepository.findByPubDateBetween(from, to, nextPage);
    }

    public Page<Book> getPageOfBooksByGenre(String genre, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.getAllBooksByGenreSlug(genre, nextPage);
    }

    public Page<Book> getPageOfBooksByTag(String tag, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.getAllBooksByTagSlug(tag, nextPage);
    }

    public Page<Book> getPageOfBooksByAuthor(String author, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.getAllBooksByAuthorSlug(author, nextPage);
    }

    public Book getBookById(Integer bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException(
                "No Book found with such id"));
    }

    public Book getBookBySlug(String slug) {
        return bookRepository.findBookBySlug(slug);
    }

    public void save(Book bookToUpdate) {
        bookRepository.save(bookToUpdate);
    }

    public List<Book> getBooksBySlugIn(List<String> cookieSlugs) {
        return bookRepository.findBooksBySlugIn(cookieSlugs);
    }
}