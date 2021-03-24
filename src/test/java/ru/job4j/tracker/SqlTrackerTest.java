package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private SqlTracker tracker;

    @Before
    public void before() {
        System.out.println("Before method");
        this.tracker = new SqlTracker();
        this.tracker.init();
    }

    @After
    public void after() {
        System.out.println("After method");
        this.tracker = null;
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("б");
        Item res = this.tracker.add(item);
        assertTrue(this.tracker.findByName(item.getName()).contains(res));
        this.tracker.delete(item.getId());
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItemOne() {
        Item item = new Item("test1");
        Item itemFirst = new Item("test2");
        this.tracker.add(item);
        this.tracker.add(itemFirst);
        List<Item> result = this.tracker.findByName(itemFirst.getName());
        assertThat(result.get(0).getName(), is(itemFirst.getName()));
        this.tracker.delete(item.getId());
        this.tracker.delete(itemFirst.getId());
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItemTwo() {
        Item item = new Item("test3");
        Item itemFirst = new Item("test4");
        Item itemSecond = new Item("test5");
        Item itemThird = new Item("test6");
        Item itemFourth = new Item("test7");
        this.tracker.add(item);
        this.tracker.add(itemFirst);
        this.tracker.add(itemSecond);
        this.tracker.add(itemThird);
        this.tracker.add(itemFourth);
        List<Item> result = this.tracker.findAll();
        assertThat(result, is(this.tracker.findAll()));
        this.tracker.delete(item.getId());
        this.tracker.delete(itemFirst.getId());
        this.tracker.delete(itemSecond.getId());
        this.tracker.delete(itemThird.getId());
        this.tracker.delete(itemFourth.getId());
    }

    @Test
    public void whenReplace() {
        Item bug = new Item("Bug");
        this.tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        this.tracker.replace(id, bugWithDesc);
        assertEquals(this.tracker.findById(id).getName(), id);
        this.tracker.delete(bug.getId());
    }

    @Test
    public void whenDelete() {
        Item bug = new Item("Bug");
        this.tracker.add(bug);
        String id = bug.getId();
        this.tracker.delete(id);
        assertThat(this.tracker.findById(id).toString(), is(nullValue()));
    }
}
