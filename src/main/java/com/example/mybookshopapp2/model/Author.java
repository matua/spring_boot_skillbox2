package com.example.mybookshopapp2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "books")
@Entity
@Table(name = "authors")
@ApiModel(description = "data model of author entity")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Author extends RepresentationModel<Author> {
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

    @ManyToMany
    @JoinTable(name = "book2author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
