package com.example.java_8_9_11_17.optional;

import java.util.Optional;
import java.util.Random;

public class OptionalDemo1 {
    public static void main(String[] args) {

        Student s;
        s = null;

        // in this case `s` is `null` so `s2` would be assigned to `Optional.empty`
        Optional<Student> s2 = Optional.ofNullable(s);
        System.out.println(s2); // Optional.empty

        // if we don't know at runtime whether we would get `null` or actual object
        // in that case also we can use `Optional.ofNullable()` method
        // it would return actual object if present
        // or else it would return `Optional.empty`

        // getStudent() method randomly returns the `null` or actual `Student` object with  `id` 1
        // we are just mocking the runtime environment where we could get either `null` or actual object
        s = getStudent();
        System.out.println("got Student at runtime: " + s);

        // it is discouraged to use `null` inside our application,
        // so we can use `Optional.ofNullable()` method to safely retrieve the `Student` object
        // or can have `Optional.empty` instead of `null`
        System.out.println("got Student at runtime: " + Optional.ofNullable(s));

        // we should convert nullable object in our application to Optional object
        Optional<Student> s3 = Optional.ofNullable(s);
        System.out.println(s3);

        // we can define the default value if the object is empty at runtime
        System.out.println(s3.orElse(new Student(0)));
    }

    static Student getStudent() {
        Random random = new Random();
        boolean flag = random.nextBoolean();
//        Student s;

//        if (flag) {
//            s = new Student(1);
//        } else {
//            s = null;
//        }

        return flag ? new Student(1) : null;
    }
}
