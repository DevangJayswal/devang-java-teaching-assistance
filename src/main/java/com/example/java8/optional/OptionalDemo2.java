package com.example.java8.optional;

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
        String actualStringOrElse  = optionalStr.orElse("NoStringAttached");
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

        String actualStringOrElseGet = optionalStr.orElseGet(()-> {
            System.out.println("We couldn't get anything. Returning `Nothing`");
            return "Nothing";
        });

        System.out.println("actualStringOrElseGet: " + actualStringOrElseGet);
    }

    static String getString() {
        boolean flag = new Random().nextBoolean();
        return flag ? "Hello" : null;
    }
}
