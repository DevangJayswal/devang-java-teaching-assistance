package com.example.demo;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaDateTimeDemo {
    public static void main(String[] args) {
        // Available Zone Ids
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("\n--- Available Zone Ids");
        AtomicInteger count = new AtomicInteger();
        availableZoneIds.forEach(s -> {
            count.getAndIncrement();
            System.out.println(s);
        });
        System.out.println("-------Total Zone Ids = " + count + " --------\n");

        // date time in Canada/Eastern
        String dateTimeInCanadaEastern = ZonedDateTime
                .now(ZoneId.of("Canada/Eastern"))
                .format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a"));

        System.out.println("dateTimeInCanadaEastern: " + dateTimeInCanadaEastern);

        // date time in Australia/Sydney
        String dateTimeInAustraliaSydney = ZonedDateTime
                .now(ZoneId.of("Australia/Sydney"))
                .format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a"));

        System.out.println("dateTimeInAustraliaSydney: " + dateTimeInAustraliaSydney);

        // date time in Inda -> Asia/Kolkata
        String dateTimeInIndia = ZonedDateTime
                .now(ZoneId.of("Asia/Kolkata"))
                .format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a"));

        System.out.println("dateTimeInIndia: " + dateTimeInIndia);

        // convert dateTime in different zone
        // Canada to India
        ZonedDateTime zonedDateTimeCanada = ZonedDateTime
                .now(ZoneId.of("Canada/Eastern"));

        System.out.println(zonedDateTimeCanada.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a")));

        ZonedDateTime zonedDateTimeIndia = zonedDateTimeCanada
                .withZoneSameInstant(ZoneId.of("Asia/Kolkata"));

        System.out.println(zonedDateTimeIndia.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a")));

        Instant instant = Instant.now();
        System.out.println(instant);

        ZonedDateTime zonedDateTimeIndiaFromInstant = instant.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println(zonedDateTimeIndiaFromInstant);



    }
}
