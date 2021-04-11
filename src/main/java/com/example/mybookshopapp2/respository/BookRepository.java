package com.example.mybookshopapp2.respository;

import com.example.mybookshopapp2.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

//    List<Book> getBooksByGenre(Genre genre);

    @Query("from Book")
    List<Book> customFindAllBooks();

    List<Book> findBookByAuthorsFirstNameContaining(String authorFirstName);

    List<Book> findBookByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceOldBetween(Integer min, Integer max);

    List<Book> findBooksByPriceOldIs(Integer price);

    @Query("from Book where isBestseller=1")
    List<Book> getBestsellers();

    //    @Query(value = "SELECT * FROM books as b JOIN book2genre as g on b.id = g.book_id WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();

    Page<Book> findBooksByTitleContaining(String bookTitle, Pageable nextPage);

//    Page<Book> findByPubDateBetween(Date from, Date to, Pageable pageable);

    @Query(value = "SELECT * FROM books WHERE pub_date >= :from AND pub_date <  :to", nativeQuery = true)
    Page<Book> findByPubDateBetween(@Param("from") Date from, @Param("to") Date to, Pageable pageable);

}