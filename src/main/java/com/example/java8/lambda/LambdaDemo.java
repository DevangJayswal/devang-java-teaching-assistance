package com.example.java8.lambda;

// this interface has only single abstract method
// so in java 8 terms we can call it Functional Interface
interface MyInterface {
    void dummy();
}

class MyInterfaceImpl implements MyInterface {
    @Override
    public void dummy() {
        System.out.println("MyInterface dummy() implementation by creating implementation class MyInterfaceImpl");
    }
}


public class LambdaDemo {
    public static void main(String[] args) {
        // we are implementing MyInterface dummy method behind the scene using lambda
        MyInterface m = () -> {
            System.out.println("MyInterface dummy() implementation using lambda");
        };
        m.dummy();

        // we implement the dummy() method using Anonymous Inner Class as well
        MyInterface m1 = new MyInterface() {
            @Override
            public void dummy() {
                System.out.println("MyInterface dummy() implementation using Anonymous Inner Class");
            }
        };
        m1.dummy();

        // conventional method to create
        MyInterfaceImpl m2 = new MyInterfaceImpl();
        m2.dummy();
    }
}
