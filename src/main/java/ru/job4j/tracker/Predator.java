package ru.job4j.tracker;

public class Predator extends Animal {
    public Predator() {
        super();
        System.out.println("Пустой Predator");
    }

    public Predator(String name) {
        super(name);
        System.out.println(name + "Хищное животное");
    }
}
