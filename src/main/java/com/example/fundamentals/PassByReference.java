package com.example.fundamentals;

class Simpson {
    String name;
}

public class PassByReference {
    public static void main(String[] args) {
        Simpson simpson = new Simpson();
        transformIntoHomer(simpson);
        System.out.println(simpson.name);
    }
    static void transformIntoHomer(Simpson simpson) {
        simpson.name = "Homer";
    }
}
