package com.example.java_8_11_17.default_method;

interface Interf{
    default void m1(){
        System.out.println("default method of interface");
    }
}

public class DefaultMethod implements Interf{
    public static void main(String[] args) {

        DefaultMethod t = new DefaultMethod();
        // calling default method of interface
        // we were able to call it because we are implementing interface, so it will be available in
        // implementing class (inheritance)
        t.m1();
    }
}
