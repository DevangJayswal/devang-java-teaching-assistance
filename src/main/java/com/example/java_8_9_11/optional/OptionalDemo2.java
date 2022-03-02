package com.example.java_8_9_11.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class OptionalDemo2 {

    public static void main(String[] args) {
        String str;

        // `getString()` may return `null` or `Hello`
        str = getString();
        System.out.println("str: " + str); // `null` or `Hello`

        // It may throw java.lang.NullPointerException:
        // Cannot invoke "String.equals(Object)" because "str" is null
        // System.out.println(str.equals("Hello"));

        // In order to avoid getting NullPointerException we should use
        // Optional.empty instead of null
        // thus avoiding NullPointerException at runtime
        System.out.println("Optional.ofNullable(str): " + Optional.ofNullable(str)); // `Optional.empty` or `Optional[Hello]`

        Optional<String> optionalStr = Optional.ofNullable(str);
        System.out.println("optionalStr: " + optionalStr); // `Optional.empty` or `Optional[Hello]`

        // it is always better to use orElse() method to retrieve the String
        // as it enforces you that what should happen if the String is null
        // we should write t
        String actualStringOrElse = optionalStr.orElse("NoStringAttached");
        System.out.println("actualStringOrElse: " + actualStringOrElse); // `NoStringAttached` or `Hello`

        // str -> `null` or `Hello`
        // optionalStr -> `Optional.empty` or `Optional[Hello]`
        // actualStringOrElse -> `NoStringAttached` or `Hello`

        // In above example we were dealing with String
        // So when we use `optionalStr.orElse()` method to get the `actualStringOrElse`, we need to specify
        // what is the String to be returned if the `optionalStr` is empty (`Optional.empty`)
        // so what we pass in the argument of `orElse("NoStringAttached")` has to be `String` object
        // but if we want to perform any operation before returning the String then you can use
        // `orElseGet()` which accepts `Supplier<String>` as an argument which returns a `String`,
        // we can use lambda expression to implement `Supplier<String>`

        String actualStringOrElseGet = optionalStr.orElseGet(() -> {
            System.out.println("We couldn't get anything. Returning `Nothing`");
            return "Nothing";
        });

        System.out.println("actualStringOrElseGet: " + actualStringOrElseGet);

        // will return `Hello` if the string is not null
        optionalStr.ifPresent(s -> {
            System.out.println("ifPresent s: " + s); // `Hello`
        });

        // NOTE: ifPresentOrElse is available from Java 9
        optionalStr.ifPresentOrElse(string -> {
            System.out.println("Value is present (Not null), string: " + string); // `Hello`
        }, () -> {
            System.out.println("Value is empty (null)");
        });

        String nullString = null;
        String emptyString = "";
        String whiteSpaceString = " ";

        System.out.println("---nullString=" + nullString + "---");
        System.out.println("---emptyString=" + emptyString + "---");
        System.out.println("---whiteSpaceString=" + whiteSpaceString + "---");

        // ERROR: NullPointerException
        // System.out.println("isEmpty: " + nullString.isEmpty());
        System.out.println("isEmpty emptyString: " + emptyString.isEmpty());
        System.out.println("isEmpty whiteSpaceString: " + whiteSpaceString.isEmpty());

        // isBlank() available from Java 11

        // ERROR: NullPointerException
        // System.out.println("isBlank: " + nullString.isBlank());
        System.out.println("isBlank emptyString: " + emptyString.isBlank());
        System.out.println("isBlank whiteSpaceString: " + whiteSpaceString.isBlank());

        // Optional is used to check for null value, not for empty or whiteSpace

        // providing null value to Optional
        Optional<String> optionalNullString = Optional.ofNullable(null);
        // providing empty value to Optional
        Optional<String> optionalEmptyString = Optional.ofNullable("");
        // providing white space value to Optional
        Optional<String> optionalWhiteSpaceString = Optional.ofNullable(" ");

        System.out.println("optionalNullString: " + optionalNullString); // Optional.empty
        System.out.println("optionalEmptyString: " + optionalEmptyString); // Optional[]
        System.out.println("optionalWhiteSpaceString: " + optionalWhiteSpaceString); //Optional[ ]

        // ifPresent method would return true and lambda expression will be executed
        // this is not an intentional behaviour
        optionalEmptyString.ifPresent(s -> System.out.println("s: " + s)); // s:
        System.out.println("optionalEmptyString.isPresent(): " + optionalEmptyString.isPresent()); // true

        // we can further check if the value is empty, blank or contains whitespace
        // using `isBlank` method
        optionalEmptyString.ifPresent(s -> {
            if (s.isBlank()) {
                System.out.println("optionalEmptyString is blank");
            }
        });

        Student s = null;
        Student s1 = new Student(1);
        // filter(Predicate) method accepts a lambda function that returns true or false
        // filter method will only be invoked when the object is not null
        Optional.ofNullable(s).filter(student -> {
            System.out.println("filter on null object"); // will not be printed, because `s` is null
            return student.randomTrueOrFalse();
        });

        //WHAT IS PREDICATE -> a function that returns true or false

        // if the object is not null, then filter method will return true or false
        //here in this case s1 is not null, so filter method will be executed
        // and would return true or false randomly
        Optional.ofNullable(s1).filter(student -> {
            System.out.println("filter on non null Object which has randomTrueOrFalse predicate");
            return student.randomTrueOrFalse();
        });

        // USE CASE:
        // 1. we need to make sure object is not null
        // 2. after then need to perform an operation on that object
        //    -> operation would return true or false
        // if the operation returns true then filter method would provide the
        // Optional<Object> otherwise null
        // If the filter method provides an object then we would want to do something,
        // so we can use ifPresent() method for that

        Optional<Student> optionalStudentWithFilterOfFalsePredicate = Optional.ofNullable(s1).filter(student -> {
            System.out.println("filter with false predicate");
            return false;
        });

        // if the predicate is true then filter method would return an Optional[Object]
        // if the predicate is false then it would return Optional.empty
        // so, we have two possibilities null or an actual Object
        // that's why filter method returns an Optional<Object>
        System.out.println(optionalStudentWithFilterOfFalsePredicate);

        Optional<Student> optionalStudentWithFilterOfTruePredicate = Optional.ofNullable(s1).filter(student -> {
            System.out.println("filter with true predicate");
            return true;
        });

        System.out.println(optionalStudentWithFilterOfTruePredicate); // Optional[Student{id=1}]

        // now we can use ifPresent method on Optional<Object> and do something
        // if it is not null or Optional.empty
        optionalStudentWithFilterOfTruePredicate.ifPresent(student -> {
            System.out.println(student); // Student{id=1}
        });
    }

    static String getString() {
        boolean flag = new Random().nextBoolean();
        return flag ? "Hello" : null;
    }
}
