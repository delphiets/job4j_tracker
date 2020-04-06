package ru.job4j.stragery;

public class Paint {
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }

    public static void main(String[] args) {
        new Paint().draw(new Square());
        System.out.println();
        new Paint().draw(new Triangle());
    }
}

