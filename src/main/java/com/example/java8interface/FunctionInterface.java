package com.example.java8interface;

import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {

        Function<String, String> upperCase = s -> s.toUpperCase();
        System.out.println(upperCase.apply("Aishwarya"));

        Function<String, String> extract = s -> s.substring(0, 9);
        System.out.println(extract.apply("AishwaryAbhi"));

        System.out.println(upperCase.andThen(extract).apply("AishwaryaAbhi"));
        System.out.println(upperCase.compose(extract).apply("AishwaryaAbhi"));

    }

}
