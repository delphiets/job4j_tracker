package ru.job4j;

import org.junit.Test;
import ru.job4j.oop.Point;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance() {
        Point one = new Point(2,0,0);
        Point tho = new Point(0,0,2);
        double sum =  one.distance3d(tho);
        double result = 2.8284271247461903;
        assertThat(result, is(sum));

    }
}