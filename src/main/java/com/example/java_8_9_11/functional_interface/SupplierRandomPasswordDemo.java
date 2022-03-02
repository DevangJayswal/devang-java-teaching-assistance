package com.example.java_8_9_11.functional_interface;

import java.util.function.Supplier;

public class SupplierRandomPasswordDemo {
    public static void main(String[] args) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";

        Supplier<Character> randomChar = () -> characters.charAt((int) (Math.random() * 29));
        Supplier<Integer> randomNumber = () -> (int) (Math.random() * 10);


        Supplier<StringBuilder> randomPassword = () -> {
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    password.append(randomChar.get());
                } else {
                    password.append(randomNumber.get());
                }
            }
            return password;
        };

        // generating 50 random password
        for (int i = 0; i < 50; i++) {
            System.out.println(randomPassword.get());
        }
    }
}
