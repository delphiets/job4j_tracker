package ru.job4j.lambda;

import java.util.Objects;
import java.util.Set;

public class Student {
    private String name;
    private Set<String> units;

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public Set<String> getUnits() {
        return units;
    }
    @Override
     public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
     }
     @Override
    public int hashCode() {
        return Objects.hash(units);
     }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", units=" + units +
                '}';
    }
}