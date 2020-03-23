package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student  = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setGroup(11);
        student.setDate("11.08.2007");
        System.out.println("Student\nName: " + student.getName() + "\nSurname: " + student.getSurname() + "\nGroup: " + student.getGroup() + "\nDate: " + student.getDate());
    }
}
