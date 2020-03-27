package ru.job4j;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenAddNewItemThenTrackerHasSameItemOne() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item itemFirst = new Item("test2");
        tracker.add(item);
        tracker.add(itemFirst);
        Item[] result = tracker.findByName(itemFirst.getName());
        assertThat(result[0].getName(), is(itemFirst.getName()));
    }
    @Test
    public void whenAddNewItemThenTrackerHasSameItemTwo() {
        Tracker tracker = new Tracker();
        Item item = new Item("test3");
        Item itemFirst = new Item("test4");
        Item itemSecond = new Item("test5");
        Item itemThird = new Item("test6");
        Item itemFourth = new Item("test7");
        tracker.add(item);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        tracker.add(itemThird);
        tracker.add(itemFourth);
        Item[] result = tracker.findAll();
        assertThat(result, is(tracker.findAll()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}