package com.example.java_8_9_11_17;

import java.util.function.Consumer;

interface Demo {
    void display(String s);
}

class MyUtil {
    void instanceMethod(String s) {
        System.out.println(s);
    }
    static void staticMethod(String s){
        System.out.println(s);
    }
}


public class FunctionalStyleDemo {


    static void staticMethod(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        // lambda expression
        Demo d = i -> System.out.println(i);
        d.display("Hello");

        // method reference (referring through class name `MyUtil`)
        Demo d1 = MyUtil::staticMethod;
        d1.display("Cool");

        // method reference (referring through object name `u`)
        MyUtil u = new MyUtil();
        Demo d2 = u::instanceMethod;

        // method reference (referring through object name `System.out`)
        Demo d3 = System.out::println;
        d3.display("Hi"); // when you call display function
        // the println function will be called with one argument


    }

    static void doSomething(Consumer action) {


    }

}
