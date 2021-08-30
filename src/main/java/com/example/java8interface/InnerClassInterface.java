package com.example.java8interface;

interface SomeInterface{
    void m1();
}

public class InnerClassInterface {
    public static void main(String[] args) {
        // by  making use of inner class we do not need to explicitly create new class to implement
        // method of interface
        SomeInterface s = new SomeInterface(){
            @Override
            public void m1() {
                System.out.println("implemented m1() of SomeInterface inside Anonymous Inner Class");
            }
        };
        s.m1();
    }
}



