package com.example;

import java.util.ArrayList;

public class Playground {
    public static int[] random(int[] x, int y) {
        int[] array = new int[3];
        for (int i = 0; i < x.length; i++) {
            if (x[i] == y) {
                array[0] = x[i] + 1;
                array[1] = x[i] + 2;
                array[2] = x[i] + 3;
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int resultArray[] = random(sortedArray, 6);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i]);
        }
    }
}

// at the time of declaring the final variable or in constructor we must define the value
// otherwise it will give an error
//    private final int i;
//    Playground(){
//        this.i = 10;
//    }

//        System.out.println(new Playground().i);
//        System.out.println(0>0);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.addAll(list);

