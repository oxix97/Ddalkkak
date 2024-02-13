package com.example.ddalkkak.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Converter {

    public static LocalDate convertTimestampToDateString(String timeStamp) {
        // Instant 객체로 변환
        Instant instant = Instant.ofEpochSecond(Long.parseLong(timeStamp));

        // Instant를 LocalDate로 변환
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date);
    }
}
