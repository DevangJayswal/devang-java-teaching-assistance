package com.example.fundamentals.serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws IOException {
        Student s = new Student(1, "Devang");
        ObjectOutputStream out =
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("student.ser")));
        // object will be stored in the root directory of the project with file name `student.ser`
        out.writeObject(s);
        out.flush();
        out.close();
    }
}

// Student class must implement marker interface `Serializable`
// otherwise we would get runtime exception: java.io.NotSerializableException
class Student implements Serializable {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
