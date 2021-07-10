package com.example.mybookshopapp2.security;

import lombok.Data;

@Data
public class ContactConfirmationPayload {
    private String contact;
    private String code;
}
