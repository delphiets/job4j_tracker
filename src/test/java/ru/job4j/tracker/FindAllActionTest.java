package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindAllActionTest {

    @Test
    public void whenCheckOutput() throws SQLException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Store sqlTracker = new SqlTracker();
        sqlTracker.init();
        Item item = new Item("fix bug");
        sqlTracker.add(item);
        FindAllAction act = new FindAllAction();
        act.execute(new StubInput(new String[]{}), sqlTracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Name: " + item.getName() + " | Id: " + item.getId())
                .toString();
        assertThat(out.toString(), is(expect));
        sqlTracker.delete(item.getId());
        System.setOut(def);
    }
}
