[Understanding null in Java](https://dev.to/dj_devjournal/understanding-null-in-java-4o31)

[How to Handle Null Pointer Exception](https://developersjournal.in/how-to-handle-null-pointer-exception-in-java/)

In Java, a special `null` value can be assigned to an object’s reference and denotes that the object is currently
pointing to **unknown** piece of data. A `NullPointerException` is thrown when an application is trying to use or access
an object whose reference equals to null. The following cases throw that exception:

* Invoking a method from a `null` object.
* Accessing or modifying a `null` object’s field.
* Taking the length of `null`, as if it were an array.
* Accessing or modifying the slots of `null` object, as if it were an array.
* Throwing `null`, as if it were a `Throwable` value.
* When you try to synchronize over a `null` object.

## How to avoid the `NullPointerException`

In order to avoid the `NullPointerException`, ensure that all your objects are initialized properly, before you use
them. Notice that, when you declare a reference variable, you are really creating a pointer to an object. You must
verify that the pointer is not null, before you request the method or a field from the object.