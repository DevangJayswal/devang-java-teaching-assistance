package com.example.java_8_9_11.functional_interface;

import java.util.function.Supplier;


// Supplier would supply something to us -> return something
// Consumer would consume something from us -> get something
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> otp = () -> {
            StringBuilder random = new StringBuilder();
            for (int i = 0; i < 6; i++) random.append((int) (Math.random() * 10));
            return random.toString();
        };
        System.out.println(otp.get());
    }
}
