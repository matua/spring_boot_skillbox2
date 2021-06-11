package com.example.mybookshopapp2.model;

import com.example.mybookshopapp2.utils.serialization.BookSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "books")
@ApiModel(description = "entity representing a book")
@JsonSerialize(using = BookSerializer.class)
public class Book extends RepresentationModel<Book> {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book2user",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<User> users = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonProperty("authors")
    @JoinTable(name = "book2author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book2genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    Set<Genre> genres = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book2tag",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<Tag> tags = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id generated by db automatically")
    private Integer id;

    @ApiModelProperty("date of book publication")
    private Date pubDate;

    @ApiModelProperty("if isBestseller = 1, the book is considered a bestseller")
    private Byte isBestseller;

    @ApiModelProperty("mnemonic identity sequence of characters")
    private String slug;

    @ApiModelProperty("image url")
    private String image;

    @Column(columnDefinition = "TEXT")
    @ApiModelProperty("book description text")
    private String description;

    @ApiModelProperty("book title")
    private String title;

    @JsonProperty("price")
    @Column(name = "price")
    @ApiModelProperty("book price without discount")
    private Integer priceOld;

    @JsonProperty("discount")
    @Column(name = "discount")
    @ApiModelProperty("discount value for book")
    private Double price;

    private Byte rating;

    @OneToMany(mappedBy = "book")
    private List<BookFile> bookFileList = new ArrayList<>();

    @JsonProperty
    public Integer discountPrice() {
        return priceOld - Math.toIntExact(Math.round(price * priceOld));
    }

    @JsonGetter("authors")
    public String authorsFullName() {
        return authors.toString();
    }
}