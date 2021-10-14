package com.example.fundamentals.anonymous_inner_class;
/*
* three ways to create Anonymous Inner class
* 1. extends a class
* 2. implements an interface
* 3. defined inside arguments
* */

public class AnonymousInnerClass {
    public static void main(String[] args) {

        Popcorn p = new Popcorn();
        p.taste();

        // our Popcorn class has salty taste, but we wanted spicy taste,
        // so we extended Popcorn class and created SubPopcorn child class
        SubPopcorn s = new SubPopcorn();
        s.taste();

        // we can implement the same thing with Anonymous inner class
        Popcorn p1 = new Popcorn(){
            @Override
            public void taste() {
                System.out.println("spicy");
            }
        };

        // we extended the Popcorn class without name and created its own implementation
        // this is called Anonymous Inner class
        p1.taste();

        // for each Anonymous class separate .class file will be generated
        // in this case, name will be `AnonymousInnerClass$1.class`
        // because Anonymous class is present inside `AnonymousInnerClass`
        // $1 because it is a first Anonymous class
        // if we have multiple Anonymous class then name will be like ...$2.class, ...$3.class and so on

        System.out.println(p1.getClass().getName());
    }
}
