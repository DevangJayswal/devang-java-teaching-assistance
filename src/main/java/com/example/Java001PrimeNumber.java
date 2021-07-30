package com.example;

import java.util.Scanner;

public class Java001PrimeNumber {
    public static void isPrime() {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number to be checked as Prime");

        int i, m, flag = 0;
        int n = myObj.nextInt();
        m = n / 2;
        if (n == 0 || n == 1) {
            System.out.println(n + " is not prime number");
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    System.out.println(n + " is not prime number");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(n + " is prime number");
            }
        }
    }
}
