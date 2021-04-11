package com.example.mybookshopapp2.utils;

public class JsToDataSqlConverter {
    public static String convert(String jsDate) {
        String[] parts = jsDate.split("\\.");
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }

}  