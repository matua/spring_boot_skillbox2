package com.example.mybookshopapp2.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author getAuthorByFirstNameOrLastName(String firstName, String lastName);
}
