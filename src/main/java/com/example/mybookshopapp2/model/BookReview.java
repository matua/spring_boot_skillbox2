package com.example.mybookshopapp2.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@Accessors(chain = true)
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer bookId;
    private Integer userId;
    private LocalDateTime time;
    private String text;
}
