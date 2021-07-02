package com.example.mybookshopapp2.respository;

import com.example.mybookshopapp2.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("from Book")
    List<Book> customFindAllBooks();

    List<Book> findBookByAuthorsFirstNameContainingIgnoreCase(String authorFirstName);

    List<Book> findBookByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceOldBetween(Integer min, Integer max);

    List<Book> findBooksByPriceOldIs(Integer price);

    @Query("from Book where isBestseller=1")
    List<Book> getBestsellers();

    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();

    Page<Book> findPageBooksByTitleLikeIgnoreCase(String bookTitle, Pageable nextPage);

    Page<Book> findByPubDateBetween(Date from, Date to, Pageable nextPage);

    Page<Book> findByPubDateAfter(Date from, Pageable nextPage);

    Page<Book> findByPubDateBefore(Date to, Pageable nextPage);

    @Query(value = "select * from books b " +
            "join book2genre bg " +
            "   on b.id = bg.book_id " +
            "join genre g " +
            "   on g.id = bg.genre_id " +
            "where g.slug = :slug", nativeQuery = true)
    Page<Book> getAllBooksByGenreSlug(String slug, Pageable nextPage);

    @Query(value = "select * from books b " +
            "join book2tag bt " +
            "   on b.id = bt.book_id " +
            "join tag t " +
            "   on t.id = bt.tag_id " +
            "where t.slug = :slug", nativeQuery = true)
    Page<Book> getAllBooksByTagSlug(String slug, Pageable nextPage);

    @Query(value = "select * from books b " +
            "join book2author ba " +
            "   on b.id = ba.book_id " +
            "join authors a " +
            "   on a.id = ba.author_id " +
            "where a.slug = :slug", nativeQuery = true)
    Page<Book> getAllBooksByAuthorSlug(String slug, Pageable nextPage);

    Book findBookBySlug(String slug);

    List<Book> findBooksByTitleContaining(String title);

    List<Book> findBooksBySlugIn(Collection<String> slug);
}