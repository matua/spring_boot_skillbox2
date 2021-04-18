package com.example.mybookshopapp2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sortIndex;
    private String slug;
    private String title;
    private String text;
}
