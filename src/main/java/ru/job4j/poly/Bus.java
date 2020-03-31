package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("Транспорт едит");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("Транспорт принимает максимум " + quantity + " пассажиров");

    }

    @Override
    public double price(double fuel) {
        return fuel * 27.99;
    }
}
