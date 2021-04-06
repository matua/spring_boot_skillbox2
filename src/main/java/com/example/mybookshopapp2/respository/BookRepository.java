package com.example.mybookshopapp2.respository;

import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> getBooksByGenre(Genre genre);

    @Query("from Book")
    List<Book> customFindAllBooks();

    List<Book> findBookByAuthorsLastName(String name);

}