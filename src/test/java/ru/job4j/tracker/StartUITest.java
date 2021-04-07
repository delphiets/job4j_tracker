package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {

    @Test
    public void whenExit() throws IOException, SQLException {
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        UserAction[] array = {action};
        new StartUI().init(input, new SqlTracker(), array);
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() throws IOException, SQLException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        UserAction[] array = {action};
        new StartUI().init(input, new SqlTracker(), array);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(System.lineSeparator() + "Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(out.toString(), is(expect));
        System.setOut(def);
    }
}
