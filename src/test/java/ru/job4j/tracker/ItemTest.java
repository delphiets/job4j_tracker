package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemTest {

    @Test
    public void sortAscending() {
        Tracker tracker = new Tracker();
        Item first = new Item("б");
        tracker.add(first);
        Item second = new Item("г");
        tracker.add(second);
        Item third = new Item("д");
        tracker.add(third);
        Item fourth = new Item("в");
        tracker.add(fourth);
        Item fifth = new Item("а");
        tracker.add(fifth);
        List<Item> item = tracker.findAll();
        item.sort(new SortNameItem());
        String[] name = {"а", "б", "в", "г", "д"};
        List<String> list = new ArrayList<>(Arrays.asList(name));
        assertThat(list.toString(), is(item.toString()));
    }

    @Test
    public void sortDescending() {
        Tracker tracker = new Tracker();
        Item first = new Item("б");
        tracker.add(first);
        Item second = new Item("г");
        tracker.add(second);
        Item third = new Item("д");
        tracker.add(third);
        Item fourth = new Item("в");
        tracker.add(fourth);
        Item fifth = new Item("а");
        tracker.add(fifth);
        List<Item> item = tracker.findAll();
        item.sort(new SortItem());
        String[] name = {"д", "г", "в", "б", "а"};
        List<String> list = new ArrayList<>(Arrays.asList(name));
        assertThat(list.toString(), is(item.toString()));
    }
}
