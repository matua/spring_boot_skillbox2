package com.example.mybookshopapp2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class FileDownload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count;
}
