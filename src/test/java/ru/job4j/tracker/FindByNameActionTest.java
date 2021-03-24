package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindByNameActionTest {

    @Test
    public void whenCheckOutput() throws IOException, SQLException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = System.out;
        System.setOut(new PrintStream(out));
        Store tracker = new SqlTracker();
        tracker.init();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindByNameAction name = new FindByNameAction();
        name.execute(new StubInput(new String[]{item.getName()}), tracker);
        String result = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Name: " + item.getName())
                .toString();
        assertThat(out.toString(), is(result));
        tracker.delete(item.getId());
        System.setOut(stream);
    }
}
