package com.example.java_8_9_11_17.lambda;

public class LambdaRunnable {

    public static void main(String[] args) {

        // implementing without lambda
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(10);
                        System.out.println("Child 1 Thread");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        // implementing Runnable with lambda
        // we can use lambda expression only if the interface has only single abstract method
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                    System.out.println("Child 2 Thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
                System.out.println("Main thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
