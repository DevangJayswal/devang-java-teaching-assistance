package com.example.java_8_9_11.method_constructor_reference;

import java.util.Arrays;
import java.util.List;


// ClassName::staticMethodName
// objectReference::methodName
public class MethodReferenceDemo1 {
    public static void main(String[] args) {

        // immutable list of integers
        List integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().forEach(System.out::println);


//        Optional<String> str = Optional.of("Hello");
//        str.ifPresent(System.out::println);

        // System -> class
        // out:PrintStream ->

    }
}
