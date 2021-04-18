package com.example.mybookshopapp2.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private Type type;
    private Byte approved;
    private String code;
    private Integer codeTrials;
    private LocalDateTime codeTime;
    private String contact;

    private enum Type {
        PHONE,
        EMAIL
    }
}