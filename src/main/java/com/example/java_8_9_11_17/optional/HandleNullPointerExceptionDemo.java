package com.example.java_8_9_11_17.optional;

public class HandleNullPointerExceptionDemo {
    public static void main(String[] args) {

        Student s=null;
        // RUNTIME Exception: java.lang.NullPointerException:
        // Cannot read field "id" because "s" is null
        // Because Accessing or modifying a `null` object’s field.
        // System.out.println(s.id);

        // How to avoid NullPointerException
        if(s==null){
            System.out.println("Please assign the object");
        }else{
            System.out.println(s.id);
        }
    }
}
