package com.example.mybookshopapp2.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
//@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "book_id", "user_id" }) })
@Data
@Accessors(chain = true)
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer bookId;
    @OneToOne
    private User user;
    private LocalDateTime time;
    @Column(columnDefinition = "text")
    private String text;
    @OneToMany(mappedBy = "reviewId")
    List<BookReviewLike> bookReviewLikes;

    public List<BookReviewLike> getAllReviewLikeByBookReviewId() {
        return bookReviewLikes
                .stream()
                .filter(bookReviewLike -> bookReviewLike.getValue() > 0)
                .collect(Collectors.toList());
    }

    public List<BookReviewLike> getAllReviewDislikeByBookReviewId() {
        return bookReviewLikes
                .stream()
                .filter(bookReviewLike -> bookReviewLike.getValue() < 0)
                .collect(Collectors.toList());
    }
}
