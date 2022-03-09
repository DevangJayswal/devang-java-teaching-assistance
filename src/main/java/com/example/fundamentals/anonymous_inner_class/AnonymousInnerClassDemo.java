package com.example.fundamentals.anonymous_inner_class;
/*
* three ways to create Anonymous Inner class
* 1. extends a class
* 2. implements an interface
* 3. defined inside arguments
* */

/*
public class Popcorn {
    public void taste(){
        System.out.println("salty");
    }
}
* */

/*
public class SubPopcorn extends Popcorn{
    @Override
    public void taste() {
        System.out.println("spicy");
    }
}
*/

// Base Class -> Popcorn -> taste(){"salty"}
// Child Class -> Subpopcorn extends Popcorn -> @O -> taste(){"spicy"}

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {

        Popcorn p = new Popcorn();
        p.taste(); // salty

        // our Popcorn class has salty taste, but we wanted spicy taste,
        // so we extended Popcorn class and created SubPopcorn child class
        SubPopcorn s = new SubPopcorn();
        s.taste(); // spicy

        // we can implement the same thing with Anonymous inner class
        Popcorn p1 = new Popcorn(){
            @Override
            public void taste() {
                System.out.println("spicy");
            }
        };
        
        // behind the scene AnonymousInner Class got created and then it has extended Popcorn class
        // and overridden taste() method and returned the object of this AnonymousInner Class
        // so you can say 
        // class AnonymousInner extends Popcorn { @override taste("spicy") }
        // Popcorn p1 = new Anonymous();

        // we extended the Popcorn class without name and created its own implementation
        // this is called Anonymous Inner class
        p1.taste(); // salty
        
        // so the advantage of AnonymousInner class is that we do not need to create
        // separate class (Subpopcorn) to override the behaviour (tasty() method) of Popcorn class
        // we can directly use AnonymousInner class

        // for each Anonymous class separate .class file will be generated
        // in this case, name will be `AnonymousInnerClass$1.class`
        // because Anonymous class is present inside `AnonymousInnerClass`
        // $1 because it is a first Anonymous class
        // if we have multiple Anonymous class then name will be like ...$2.class, ...$3.class and so on

        System.out.println(p1.getClass().getName());
    }
}
