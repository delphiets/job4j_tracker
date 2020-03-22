package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student  = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setGroup(11);
        student.getDate(new Date());
        System.out.println("Student\nName: " + student.getName() + "\nSurname: " + student.getSurname() + "\nGroup: " + student.getGroup());
    }
}
