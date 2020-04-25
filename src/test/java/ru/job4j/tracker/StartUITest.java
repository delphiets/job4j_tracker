package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {
    @Test
    public void whenExit() throws IOException {
        StubInput input = new StubInput(new String[] {"0"});
        StubAction action = new StubAction();
        List<UserAction> array = new ArrayList<>();
        array.add(action);
        new StartUI().init(input, new Tracker(), array);
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(new String[] {"0"});
        StubAction action = new StubAction();
        List<UserAction> array = new ArrayList<>();
        array.add(action);
        new StartUI().init(input, new Tracker(), array);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(System.lineSeparator() + "Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }



}
