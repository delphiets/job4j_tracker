package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindByNameActionTest {
    @Test
    public void whenCheckOutput() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindByNameAction name = new FindByNameAction();
        name.execute(new StubInput(new String[] {item.getName()}), tracker);
        String result = new StringJoiner(System.lineSeparator(),  "", System.lineSeparator())
                .add(item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(result));
        System.setOut(stream);
    }
}
