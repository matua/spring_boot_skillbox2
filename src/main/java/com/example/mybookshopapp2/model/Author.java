package com.example.mybookshopapp2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "books")
@ToString(exclude = "books")
@Entity
@Table(name = "authors")
@ApiModel(description = "data model of author entity")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "author id generated by db", position = 1)
    private Integer id;
    @ApiModelProperty(value = "author first name", example = "Jonathan", position = 2)
    private String firstName;
    @ApiModelProperty(value = "author last name", example = "Matua", position = 3)
    private String lastName;
    private String slug;
    @Column(columnDefinition = "TEXT")
    private String biography;
    private String image;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "book2author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();
}
