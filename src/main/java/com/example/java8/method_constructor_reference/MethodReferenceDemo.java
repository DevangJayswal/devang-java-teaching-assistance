package com.example.java8.method_constructor_reference;

// instead of lambda expression we can use method reference

// Interef is a functional interface as it had only one method i.e. m1()
interface Interef {
    void m1();
}


// if static method
// ClassName::staticMethodName

// if non-static or instance method
// objectReference::methodName

public class MethodReferenceDemo {

    static void m2() {
        System.out.println("static m2() method reference");
    }

    void m3(){
        System.out.println("non-static m3() method reference");
    }

    public static void main(String[] args) {
        // in order to implement m1() method of functional interface Interef
        // we can use lambda expression
        Interef i = () -> System.out.println("m1()");
        i.m1();

        // now let's say instead of implementing m1() from the scratch
        // you want to use another method as an implementation for m1()

        // for e.g. we have method m2()
        // you want to use m2() as an implementation for m1() then you can use
        // method reference
        Interef i1 = MethodReferenceDemo::m2; // we do not use () at the end of methodName
        i1.m1();

        MethodReferenceDemo m = new MethodReferenceDemo();
        Interef i2 = m::m3;
        i2.m1();

        // In the lambda expression we are providing completely new implementation
        // but in the case of method reference we are not providing new implementation
        // already existing method we are reusing for the implementation of functional interface

        // advantage of using method reference is code re-usability

        // RESTRICTIONS:
        // 1. both methods should have same argument type
    }
}
