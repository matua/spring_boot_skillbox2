package com.example.mybookshopapp2.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book2user",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<User> users = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime pubDate;
    private Byte isBestseller;
    private String slug;
    private String image;
    private String description;
    @ManyToOne
//    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @JoinTable(name = "book2author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Author author;
    private String title;
    private String priceOld;
    private String price;
    private Byte discount;
    @ManyToOne
    @JoinTable(name = "book2genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Genre genre;

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPriceOld() {
        return priceOld;
    }

    public Book setPriceOld(String priceOld) {
        this.priceOld = priceOld;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Book setPrice(String price) {
        this.price = price;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public Book setUsers(Set<User> users) {
//        this.users = users;
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", author=" + author +
//                ", title='" + title + '\'' +
//                ", priceOld='" + priceOld + '\'' +
//                ", price='" + price + '\'' +
//                ", genre=" + genre +
//                ", users=" + users +
//                '}';
//    }
}
