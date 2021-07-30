package com.example;

import com.example.sorting.Java001BubbleSort;

public class MainApp {
    public static void main(String[] args) {
//        // check if the number is prime
//        Java001PrimeNumber.isPrime();
//        // convert string to uppercase
//        Java002ConvertToUpperCase.convert();

        // bubble sort
        int[] list = new int[]{5, 8, 1, 6, 9, 2};
        Java001BubbleSort.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
