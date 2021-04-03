package com.example.mybookshopapp2.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAll();

//    @Query("from Book")
//    List<Book> customFindAllBooks();
}
