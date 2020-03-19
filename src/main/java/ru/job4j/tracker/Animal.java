package ru.job4j.tracker;

public class Animal {

    private String name;

    public Animal() {
        System.out.println("Пустой");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println(name + "Животное");
    }
}
