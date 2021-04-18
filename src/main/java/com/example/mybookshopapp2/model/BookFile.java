package com.example.mybookshopapp2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class BookFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hash;
    private Integer typeId;
    private String path;
}
