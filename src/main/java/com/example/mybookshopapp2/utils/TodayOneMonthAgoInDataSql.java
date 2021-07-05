package com.example.mybookshopapp2.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodayOneMonthAgoInDataSql {

    public static Date[] getDates() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = today.minusMonths(1);
        Date[] dates = new Date[2];
        DateTimeFormatter dateSqlFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dates[0] = Date.valueOf(dateSqlFormatter.format(oneMonthAgo));
        dates[1] = Date.valueOf(dateSqlFormatter.format(today));
        return dates;
    }
}
