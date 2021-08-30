package com.example.lambda;

interface Interf {
    void m1();
}

public class LambdaLocalFinalVariable {
    // instance variable
    int x = 10;

    void m2() {
        int y = 20;
        Interf i = () -> {
            System.out.println(x);
            System.out.println(y);

//          y=888; // ERROR // we cannot change value of y because y is local variable of method m2
            // thus inside lambda expression it becomes final
            x = 999; // we can change the value of x because x is instance variable of class
            System.out.println(x);
        };
        i.m1();
    }

    public static void main(String[] args) {
        LambdaLocalFinalVariable l = new LambdaLocalFinalVariable();
        l.m2();
    }
}
