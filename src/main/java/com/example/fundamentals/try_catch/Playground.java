package com.example.fundamentals.try_catch;

public class Playground {
    public static void main(String[] args) {
        try {
            System.out.println("try 1");
            int[] arr = {0};
            arr[1] = 1;

        } catch (Exception e) {
            System.out.println("exception 1");

        }
        try {
            System.out.println("try 2");

        } catch (Exception e) {
            System.out.println("exception 2");
        }


    }
}
