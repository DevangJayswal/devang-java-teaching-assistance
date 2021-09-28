package com.example.java8;

interface Left{
    default void m1(){
        System.out.println("Left m1()");
    }
}

interface Right{
    default void m1(){
        System.out.println("Right m1()");
    }
}

// ERROR: inherits unrelated defaults for m1() if we do not override m1
// ambiguity problem
public class DefaultMethodMultipleInheritance implements Left, Right{
    public void m1(){
        Left.super.m1();
    }

    public static void main(String[] args) {
        DefaultMethodMultipleInheritance d = new DefaultMethodMultipleInheritance();
        d.m1();
    }
}
