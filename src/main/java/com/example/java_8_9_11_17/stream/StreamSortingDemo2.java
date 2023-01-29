package com.example.java_8_9_11_17.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortingDemo2 {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("rvk");
        l.add("rk");
        l.add("rkv");
        l.add("rvki");
        l.add("rvkir");
        System.out.println(l);


        // if we want to sort the elements present inside the stream then we should go for sorted() method.
        // the sorting can either default natural sorting order or customized sorting order specified by
        // comparator.

        // sorted()- default natural sorting order
        List<String> l3 = l.stream().sorted().collect(Collectors.toList());
        System.out.println("according to default natural sorting order:" + l3);

        // sorted(Comparator c)-customized sorting order.
        Comparator<String> stringComparator = (s1, s2) -> -s1.compareTo(s2);
        List<String> l4 = l.stream().sorted(stringComparator).collect(Collectors.toList());
        System.out.println("according to customized sorting order:" + l4);

        Collections.sort(l);

    }
}
