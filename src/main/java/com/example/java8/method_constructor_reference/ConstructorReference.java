package com.example.java8.method_constructor_reference;

interface FnInterface{
    Sample m1();

}
class Sample{
    public Sample() {
        System.out.println("Sample created");
    }
}

public class ConstructorReference {


    public static void main(String[] args) {
        // we have a functional interface FnInterface
        // we are supposed to provide an implementation for method m1()
        // m1() should return the Sample object

        // 1. using lambda expression
        FnInterface i = ()-> new Sample();
        i.m1();

        FnInterface i2 = ()->{
            System.out.println("FnInterface.m1()");
            return new Sample();
        };
        i2.m1();

        // 2. using constructor reference
        FnInterface i3 = Sample::new;
        i3.m1();
    }
}
