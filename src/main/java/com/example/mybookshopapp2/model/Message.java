package com.example.mybookshopapp2.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime time;
    private Integer userId;
    private String email;
    private String name;
    private String subject;
    private String text;
}
