package com.example.fundamentals.collection;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(2);

        // List preserves the order
        // duplicates are allowed
        System.out.println("List");
        numberList.forEach(System.out::println);

        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(9);
        numberSet.add(7);
        numberSet.add(8);
        numberSet.add(9);

        /* ArrayList Is the best choice for Retrieval Operations.
         * LinkedList is the best choice for insertion and deletion in the middle .
         */

        System.out.println("Set (Integer)");
        numberSet.forEach(System.out::println);

        Set<String> stringSet = new HashSet<>();
        stringSet.add("one");
        stringSet.add("two");
        stringSet.add("three");
        stringSet.add("four");
        stringSet.add("five");
        stringSet.add("one");

        // Set follows unordered way.
        // Duplicate item will be ignored in Set
        System.out.println("Set (String)");
        stringSet.forEach(System.out::println);



        /*
         * Set (String)
         * four
         * one
         * two
         * three
         * five
         */

        /* ArrayList vs HashSet
         * Duplicates :
           ArrayList allows duplicate values while HashSet doesn’t allow duplicates values.
         *
         * Ordering :
           ArrayList maintains the order of the object in which they are inserted while HashSet is an
           unordered collection and doesn’t maintain any order.

         * Indexing :
           ArrayList is index based we can retrieve object by calling get(index) method or
           remove objects by calling remove(index) method while HashSet is completely object based.
           HashSet also does not provide get() method.
         */




    }
}
