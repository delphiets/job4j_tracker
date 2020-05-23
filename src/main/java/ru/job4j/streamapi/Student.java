package ru.job4j.streamapi;

import java.util.Objects;

public class Student {
    private String surName;
    private int score;

    public Student(String surName, int score) {
        this.surName = surName;
        this.score = score;
    }

    public String getSurName() {
        return surName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(score, student.score);
    }
    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "surName='" + surName + '\'' +
                ", score=" + score +
                '}';
    }
}
