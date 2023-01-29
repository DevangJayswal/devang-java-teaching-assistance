package com.example.java_8_11_17.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            l1.add(i);
        }
        System.out.println(l1);
        List<Integer> l2 = l1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(l2);

        // https://www.baeldung.com/java-stream-to-list-collecting
        // https://stackoverflow.com/questions/65969919/differences-of-java-16s-stream-tolist-and-stream-collectcollectors-tolist

        String[] isoCountries = Locale.getISOCountries();
        // .collect(Collectors.toList()) -> Mutable -> Java 8
        List<String> result = Stream.of(isoCountries).collect(Collectors.toList());

        // .collect(Collectors.toUnmodifiableList()); // Immutable, null not allowed -> Java 10
        List<String> result1 = Stream.of(Locale.getISOCountries()).collect(Collectors.toUnmodifiableList());

        // .toList(); -> Immutable, null allowed -> Java 16
        List<String> result2 = Stream.of(Locale.getISOCountries()).toList();

    }
}
