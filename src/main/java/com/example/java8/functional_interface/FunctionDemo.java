package com.example.java8.functional_interface;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {

        // first generic parameter is input type and second is return type
        Function<String, String> upperCase = s -> s.toUpperCase();
        System.out.println(upperCase.apply("Aishwarya"));

        Function<String, String> extract = s -> s.substring(0, 9);
        System.out.println(extract.apply("AishwaryAbhi"));

        System.out.println(upperCase.andThen(extract).apply("AishwaryaAbhi"));
        System.out.println(upperCase.compose(extract).apply("AishwaryaAbhi"));

        System.out.println("--- difference between andThen and compose");

        Function<Integer, Integer> sum = n -> n+n;
        Function<Integer, Integer> cube = n -> n*n*n;

        System.out.println("sum andThen cube: " + sum.andThen(cube).apply(2));
        System.out.println("sum compose cube: " + sum.compose(cube).apply(2));

    }

}
