package ru.job4j.stragery;

import java.util.StringJoiner;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringJoiner triangle = new StringJoiner(System.lineSeparator());
        triangle.add("     *");
        triangle.add("    ***");
        triangle.add("   *****");
        triangle.add("  *******");
        triangle.add(" *********" + System.lineSeparator());
        return triangle.toString();
    }
}
