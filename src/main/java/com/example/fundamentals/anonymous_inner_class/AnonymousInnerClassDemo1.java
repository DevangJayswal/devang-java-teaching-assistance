package com.example.fundamentals.anonymous_inner_class;

public class AnonymousInnerClassDemo1 {
    /*
     * three ways to create Anonymous Inner class
     * 1. extends a class
     * 2. implements an interface
     * 3. defined inside argument
     * */

    /**
     * there are two ways to create thread
     * 1. extend Thread class
     * 2. implement Runnable interface
     */

    public static void main(String[] args) {


        // let's define a thread using Anonymous inner class by extending Thread class
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Child thread extending Thread class");
                }
            }
        };

        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }

        // let's define a thread using Anonymous inner class by implementing Runnable interface
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Child thread implementing Runnable interface");
                }
            }
        };

        // here r is Runnable implemented class object
        Thread t1 = new Thread(r);
        t1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Child thread implementing Runnable interface defined inside argument");
                }
            }
        }).start();
    }
}
