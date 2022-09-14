package com.example.demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class JavaDateTimeDemo1 {
    public static void main(String[] args) {

//        https://www.baeldung.com/java-datetimeformatter

        ZoneId zone = ZoneId.of("Canada/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDate.of(2022, 11, 6),
                LocalTime.of(1, 55, 0), zone);

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Canada/Eastern"))
                .plusDays(52).plusHours(13).plusMinutes(33);

        String nowFormatted = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .format(now);

//        System.out.println(now);
        System.out.println(nowFormatted);
//        System.out.println(zonedDateTime);


    }
}
