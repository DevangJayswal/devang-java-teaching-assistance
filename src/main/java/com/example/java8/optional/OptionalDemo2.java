package com.example.java8.optional;

import java.util.Optional;
import java.util.Random;

public class OptionalDemo2 {

    public static void main(String[] args) {
        String str;

        // `getString()` may return `null` or `Hello`
        str = getString(); // null or `Hello`
        System.out.println("str: " + str);

        // It may throw java.lang.NullPointerException:
        // Cannot invoke "String.equals(Object)" because "str" is null
        // System.out.println(str.equals("Hello"));

        // In order to avoid getting NullPointerException we should use
        // Optional.empty instead of null
        // thus avoiding NullPointerException at runtime
        System.out.println(Optional.ofNullable(str)); // Optional.empty or Optional[Hello]

        Optional<String> optionalStr = Optional.ofNullable(str);
        System.out.println("optionalStr: " + optionalStr);

        String actualString  = optionalStr.orElse("NoStringAttached");
        System.out.println("actualString: " + actualString);

        // str -> null or Hello
        // optionalStr -> Optional.empty or Optional[Hello]
        // actualString -> NoStringAttached or Hello
    }

    static String getString() {
        boolean flag = new Random().nextBoolean();
        return flag ? "Hello" : null;
    }
}
