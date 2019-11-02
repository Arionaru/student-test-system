package ru.ariona.testingSystem.domain;

public class Student {

    private String name;

    private int point;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void incrementPoint() {
        point++;
    }


}
