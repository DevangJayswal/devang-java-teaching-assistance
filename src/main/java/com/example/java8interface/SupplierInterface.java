package com.example.java8interface;

import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {
        Supplier<String> otp = () -> {
            StringBuilder random = new StringBuilder();
            for (int i = 0; i < 6; i++) random.append((int) (Math.random() * 10));
            return random.toString();
        };
        System.out.println(otp.get());
    }
}
