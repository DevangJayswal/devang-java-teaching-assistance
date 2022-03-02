package com.example.java_8_9_11.optional;

import java.util.Random;

public class NullPointerExceptionDemo {
    public static void main(String[] args) {

        String str;

        // COMPILE TIME ERROR: Variable 'str' might not have been initialized
        // System.out.println(str);

        str = null;
        System.out.println(str); // null

        // RUNTIME Exception: java.lang.NullPointerException:
        // Cannot invoke "String.equals(Object)" because "str" is null
        // Because Invoking a method from a `null` object
//        str.equals("Test");

        Student s;
        // COMPILE TIME ERROR: Variable 's' might not have been initialized
        // System.out.println(s);

        s = null;
        System.out.println(s); // null

        // RUNTIME Exception: java.lang.NullPointerException:
        // Cannot read field "id" because "s" is null
        // Because Accessing or modifying a `null` object’s field.
        // System.out.println(s.id);

        Integer i = null;
        // RUNTIME Exception: java.lang.NullPointerException:
        // Cannot invoke "java.lang.Integer.intValue()"
        // because "i" is null
        // System.out.println(i==1);

    }
}

class Student {
    int id;

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

    boolean randomTrueOrFalse() {
        return new Random().nextBoolean();
    }
}
