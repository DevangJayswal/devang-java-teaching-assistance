package com.example.java_8_11_17.functional_interface;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

// function that accepts Consumer as an argument
public class ConsumerDemo1 {

    static void doSomething(String[] strings, Consumer<String> action) {
        for (String s : strings) {
            action.accept(s);
        }
    }

    public static void main(String[] args) {
        Consumer<String> action = i -> System.out.println("--- " + i + " ---");
        String[] source = {"a", "b", "c"};

        // you can pass Consumer as an argument
        doSomething(source, action);

        Arrays.asList("p", "q", "r").stream().forEach(action);

        Stream.of("x", "y", "z").forEach(action);
    }
}
