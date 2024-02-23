package com.example.ddalkkak.util;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Slf4j
public class Converter {
    public static LocalDate convertTimestampToDateString(String timeStamp) {
        // Instant 객체로 변환
        Instant instant = Instant.ofEpochSecond(Long.parseLong(timeStamp.split("\\.")[0]));

        // Instant를 LocalDate로 변환
        return instant.atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date);
    }
}
