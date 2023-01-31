package com.example.fundamentals.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        // duplicates are ignored in Set

        Set<String> names = new HashSet<>();
        names.add("x");
        names.add("q");
        names.add("a");

        System.out.println("HashSet: Insertion Order Not Preserved");
        names.forEach(System.out::println);

        Set<String> nameTreeSet = new TreeSet<>();
        nameTreeSet.add("x");
        nameTreeSet.add("q");
        nameTreeSet.add("a");

        System.out.println("TreeSet: Sorted");
        nameTreeSet.forEach(System.out::println);

        Set<String> nameLinkedHashSet = new LinkedHashSet<>();
        nameLinkedHashSet.add("x");
        nameLinkedHashSet.add("q");
        nameLinkedHashSet.add("a");

        System.out.println("LinkedHashSet: Insertion Order Preserved");
        nameLinkedHashSet.forEach(System.out::println);


    }
}

