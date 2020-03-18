package ru.job4j;

import org.junit.Test;
import ru.job4j.oop.Point;
import ru.job4j.oop.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point first = new Point(0,2);
        Point second = new Point(0,0);
        Point third = new Point(2,0);
        Triangle triangle = new Triangle(first,second,third);
        double result = triangle.area();
        assertThat(result, is(3.9999999999999973));

    }
}