package com.example.mybookshopapp2.utils;

import java.sql.Date;

public class JsToDataSqlConverter {
    public static Date convert(String jsDate) {
        String[] parts = jsDate.split("\\.");
        return Date.valueOf(parts[2] + "-" + parts[1] + "-" + parts[0]);
    }

}  