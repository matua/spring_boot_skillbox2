package com.example.mybookshopapp2.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class BookReviewLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer reviewId;
    private Integer userId;
    private LocalDateTime dateTime;
    private Byte value;
}
