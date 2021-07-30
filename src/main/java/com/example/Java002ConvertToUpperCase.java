package com.example;

import java.util.Scanner;

public class Java002ConvertToUpperCase {
    public static void convert() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter string to be converted to uppercase");

        String str = myObj.nextLine();

        char[] characters = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            characters[i] = str.charAt(i);
        }

        for (int i = 0; i < characters.length; i++) {
            int temp = characters[i];
            temp = temp - 32;
            characters[i] = (char) temp;
        }

        String upperCased = new String(characters);
        System.out.println(upperCased);

    }
}
