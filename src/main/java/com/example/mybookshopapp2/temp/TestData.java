package com.example.mybookshopapp2.temp;

import com.example.mybookshopapp2.model.User;

public class TestData {
    public static User getTestUser() {
        return new User()
                .setId(50);
    }
}