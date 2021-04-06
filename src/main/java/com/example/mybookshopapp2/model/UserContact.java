package com.example.mybookshopapp2.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
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

    public Integer getUserId() {
        return userId;
    }

    public UserContact setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Type getType() {
        return type;
    }

    public UserContact setType(Type type) {
        this.type = type;
        return this;
    }

    public Byte getApproved() {
        return approved;
    }

    public UserContact setApproved(Byte approved) {
        this.approved = approved;
        return this;
    }

    public String getOcde() {
        return code;
    }

    public UserContact setOcde(String ocde) {
        this.code = ocde;
        return this;
    }

    public Integer getCodeTrials() {
        return codeTrials;
    }

    public UserContact setCodeTrials(Integer codeTrials) {
        this.codeTrials = codeTrials;
        return this;
    }

    public LocalDateTime getCodeTime() {
        return codeTime;
    }

    public UserContact setCodeTime(LocalDateTime codeTime) {
        this.codeTime = codeTime;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public UserContact setContact(String contact) {
        this.contact = contact;
        return this;
    }
}