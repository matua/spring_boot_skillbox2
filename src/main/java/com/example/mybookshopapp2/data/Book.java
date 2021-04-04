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
    //    @ManyToOne
////    @JoinColumn(name = "author_id", referencedColumnName = "id")
//    @JoinTable(name = "book2author",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @ManyToMany(cascade = CascadeType.ALL/*, fetch = FetchType.EAGER*/)
    @JoinTable(name = "book2author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    Set<Author> authors = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime pubDate;
    private Byte isBestseller;
    private String slug;
    private String image;
    private String description;
    //    private Author author;
    private String title;
    private String priceOld;
    private String price;
    private Byte discount;
    @ManyToOne
    @JoinTable(name = "book2genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Genre genre;

    public Set<User> getUsers() {
        return users;
    }

    public Book setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public Book setAuthors(Set<Author> authors) {
        this.authors = authors;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public Book setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public Byte getIsBestseller() {
        return isBestseller;
    }

    public Book setIsBestseller(Byte isBestseller) {
        this.isBestseller = isBestseller;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public Book setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Book setImage(String image) {
        this.image = image;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
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

    public Byte getDiscount() {
        return discount;
    }

    public Book setDiscount(Byte discount) {
        this.discount = discount;
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
