package com.example.fundamentals.serialization;

import java.io.*;

public class DeserializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("student.ser")));
        Student student = (Student) in.readObject();

        System.out.println(student);

        in.close();
    }
}
