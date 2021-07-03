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
    @OneToOne
    private User user;
    private LocalDateTime time;
    @Column(columnDefinition="text")
    private String text;
}
