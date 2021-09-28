package com.example.fundamentals;

public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        // autoboxing, because 10 is primitive value, and we can not directly convert primitive to object
        // this was not possible until java 1.4
        // but in java 1.5 we can do that using autoboxing means compiler will automatically convert primitive
        // to object
        // behind the scene it will perform Integer.valueOf(10)
        Integer i = 10;

        // new Integer(20); // deprecated
        // here j is assigned integer object
        Integer j = Integer.valueOf(20);

        // unboxing
        // compiler will automatically convert integer object to primitive value
        int k = j;
    }
}
