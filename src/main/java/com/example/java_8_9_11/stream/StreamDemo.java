package com.example.java_8_9_11.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamDemo {
    public static void main(String[] args) {
        String[] stringArray = {"a", "b", "c"};
        List<String> stringList = Arrays.asList("x", "y", "z");

        // enhanced for loop
        for (String s : stringArray) {
            System.out.println(s);
        }

        // forEach
        stringList.forEach(System.out::println);
        // forEach can be used only with collection
        // you cannot use stringArray

        // forEach (Behind the scene)
        stringList.forEach(s -> System.out.println(s));


    }
    static void myForEach(List<String> source, Consumer action){

    }
}
