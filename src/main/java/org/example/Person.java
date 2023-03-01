package org.example;

public class Person {

    private String name;
    private int age;
    private boolean married;
    private double height;

    public Person(String name, int age, boolean married, double height) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return married;
    }

    public double getHeight() {
        return height;
    }


}
