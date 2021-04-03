package com.example.mybookshopapp2.data;

import javax.persistence.*;

@Entity
@Table
public class BookFileType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Name name;
    private String description;

    private enum Name {
        PDF("PDF"),
        EPUB("EPUB"),
        FB2("FB2");

        Name(String bookFileType) {
        }
    }
}
