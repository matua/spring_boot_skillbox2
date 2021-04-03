package com.example.mybookshopapp2.data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
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

    public Integer getId() {
        return id;
    }

    public Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Message setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Message setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Message setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public Message setName(String name) {
        this.name = name;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Message setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getText() {
        return text;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }
}
