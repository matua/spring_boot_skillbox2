package com.example.mybookshopapp2.data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hash;
    private LocalDateTime regTime;
    private BigDecimal balance;
    private String name;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public User setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public User setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public User setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    //    @ManyToMany(mappedBy = "users")
//    private Set<Book> books = new HashSet<>();


//    public Set<Book> getBooks() {
//        return books;
//    }
//
//    public User setBooks(Set<Book> books) {
//        this.books = books;
//        return this;
//    }
}
