package com.example.java8.functional_interface;

// Consumer -> functional interface
// accept() -> one and only method of Consumer

// Consumer consume something from us -> get something
// Supplier supplies something to us => return something

import java.util.function.Consumer;

public class ConsumerDemo {

    static void show(String s) {
        System.out.println("---- " + s + " ----");

    }

    public static void main(String[] args) {

        // we are supposed to provide an implementation for accept() method
        // of functional interface Consumer

        // 1. using lambda expression
        Consumer c = i -> System.out.println(i);
        c.accept("hi");
        c.accept("how are you");
        c.accept(10);

        Consumer<String> c1 = i -> System.out.println(i);
        c.accept("hey");

        // 2. using method reference
        Consumer<String> c2 = ConsumerDemo::show;
        c2.accept("cool");

        Consumer<String> c3 = System.out::println;
        c3.accept("i like it");
    }
}
