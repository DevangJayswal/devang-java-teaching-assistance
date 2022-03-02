package com.example.java_8_9_11.optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        // When to use Optional
        // If you think that your object could return null value
        // you can better manage what to do when it returns null value
        // and avoid NullPointerException at runtime

        Optional<Integer> i;

        // COMPILE TIME ERROR: Variable 'i' might not have been initialized
        // System.out.println(i);

        i = null;
        System.out.println(i); // null

        // RUNTIME Exception: java.lang.NullPointerException:
        // Cannot invoke "java.util.Optional.isPresent()" because "i" is null
        // Because Accessing a `null` object’s field.
        // System.out.println(i.isPresent());

        // we should use .ofNullable method in order to indicate the value is null
        // we should not assign `null` directly to variable
        // coz it will lead to RUNTIME Exception: java.lang.NullPointerException:

        // Let's reassign the value of `i`
        i = Optional.ofNullable(null);
        System.out.println(i); // Optional.empty

        // so basically we replace `null` with `Optional.empty`

        // better way to do the same thing is by:
        i = Optional.empty();
        System.out.println(i); // Optional.empty

        // the idea is to avoid using `null` and replace it with `Optional.empty`

        // this is how we should retrieve the value
        // we are specifying that if the value is not present
        // use this default value
        System.out.println(i.orElse(0)); // 0

        // Optional with a non-null value:
        i = Optional.of(10);
        System.out.println(i); // Optional[10]

        // in this case the value is present, so it would return 10
        System.out.println(i.orElse(0)); // 10

        // alternatively we can use `get()` method in order to retrieve the value
        System.out.println(i.get()); // 10

        // advantage of using `orElse()` method is that we can provide the default value at runtime
        // if the value is not present

        // let's empty the object
        i = Optional.empty();
        System.out.println(i);

        // RUNTIME Exception: java.util.NoSuchElementException: No value present
        // System.out.println(i.get());

        // how to avoid getting runtime `NoSuchElementException`

        // in this case the value is not present and condition would be false
        // so won't print anything, and we are eliminating runtime `NoSuchElementException`
        if(i.isPresent()){
            System.out.println(i.get());
        }

        // the disadvantage of using `get()` method is that it could throw a runtime exception if the value is not
        // present
        // using `get()` method is not the recommended use of Optional
        // (it's not much of an improvement over nested null checks)
    }
}

// Optional is a container object used to contain not-null objects. Optional object is used to represent
// null with absent value. This class has various utility methods to facilitate code to handle values
// as ‘available’ or ‘not available’ instead of checking null values.

// The purpose of the Optional is to provide a type-level solution for representing optional values
// instead of null references.
