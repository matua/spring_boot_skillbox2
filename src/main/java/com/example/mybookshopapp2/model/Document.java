package com.example.mybookshopapp2.model;

import javax.persistence.*;

@Entity
@Table
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sortIndex;
    private String slug;
    private String title;
    private String text;

    public Integer getId() {
        return id;
    }

    public Document setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public Document setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public Document setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Document setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public Document setText(String text) {
        this.text = text;
        return this;
    }
}
