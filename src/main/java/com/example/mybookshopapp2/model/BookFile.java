package com.example.mybookshopapp2.model;

import javax.persistence.*;

@Entity
@Table
public class BookFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hash;
    private Integer typeId;
    private String path;

    public Integer getId() {
        return id;
    }

    public BookFile setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public BookFile setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public BookFile setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getPath() {
        return path;
    }

    public BookFile setPath(String path) {
        this.path = path;
        return this;
    }
}
