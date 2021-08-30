package com.example;

import com.example.sorting.Java001BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
//        // check if the number is prime
//        Java001PrimeNumber.isPrime();
//        // convert string to uppercase
//        Java002ConvertToUpperCase.convert();

//        // bubble sort
//        int[] list = new int[]{5, 8, 1, 6, 9, 2};
//        Java001BubbleSort.sort(list);
//        for (int i : list) {
//            System.out.println(i);
//        }

        // longest even number list
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(28);
//        list.add(26);
//        list.add(1);

        list.add(2); // 1, 1
        list.add(3);
        list.add(4); // 2, 1
        list.add(6); // 2, 2
        list.add(1);
        list.add(3);
        list.add(8); // 3, 1
        list.add(10); // 3, 2
        list.add(12); // 3, 3
        list.add(13);
        list.add(15);
        list.add(18); // 4, 1
        list.add(13);
        list.add(2); // 5, 1
        list.add(4); // 5, 2
        list.add(6); // 5, 3
        list.add(8); // 5, 4

        list.add(7); // 5, 4

        list.add(2); // 5, 1
        list.add(4); // 5, 2
        list.add(10); // 5, 3
        list.add(8); // 5, 4
        list.add(14); // 5, 4

        List<Integer> x = Java003LongestEvenList.getLongestEvenNumberList(list);
        System.out.println(x);
    }
}
