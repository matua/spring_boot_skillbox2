package com.example.mybookshopapp2.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@Accessors(chain = true)
public class BookReviewLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "book_review_id", referencedColumnName = "id")
    private BookReview reviewId;
    private Integer userId;
    private LocalDateTime dateTime;
    private Byte value;
}
