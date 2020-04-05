package ru.job4j.tracker;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {
    @Test
    public void whenExit() throws IOException {
        StubInput input = new StubInput(new String[] {"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action });
        assertThat(action.isCall(), is(true));
    }

}
