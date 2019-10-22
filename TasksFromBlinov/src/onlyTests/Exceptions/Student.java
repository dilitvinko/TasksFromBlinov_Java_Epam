package onlyTests.Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Student {
    private int id;
    private String name;
    private int age;
    public boolean check;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.age;
    }
}



