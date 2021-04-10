package com.example.mybookshopapp2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer parentId;
    private String slug;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "book2genre",
//            joinColumns = @JoinColumn(name = "genre_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public Genre setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Genre setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public Genre setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getName() {
        return name;
    }

    public Genre setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Genre setBooks(Set<Book> books) {
        this.books = books;
        return this;
    }
}
