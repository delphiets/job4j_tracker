package ru.job4j;

import org.junit.Test;
import ru.job4j.oop.Max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1,2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax1To3Then3() {
        int result = Max.max(1,2,3);
        assertThat(result, is(3));
    }
    @Test
    public void whenMax1To4Then4() {
        int result = Max.max(1,2,3,4);
        assertThat(result, is(4));
    }
}