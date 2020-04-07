package ru.job4j.ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)

    public void whenArgumentLessThanZero() {
        new Fact().calc(-10);
    }
}
