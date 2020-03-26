package ru.job4j.tracker;

import org.w3c.dom.ls.LSOutput;
import ru.job4j.tracker.Item;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[size++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(ids++);
    }

    public Item[] findAll() {
        Item[] items = new Item[size];

        for (int index = 0; index < size; index++) {
            items[index] = this.items[index];
        }
        items = Arrays.copyOf(items, size);
        return items;
    }

    public Item[] findByName(String key) {
        Item[] items = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = this.items[index];
            if (item.getName().equals(key)) {
                items[0] = this.items[index];
                count++;
            }
        }
        items = Arrays.copyOf(items, count);
        return items;
    }
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item replace(String id, Item item) {
        int index = indexOf(id);
        String a = item.getName();
        items[index].setName(a);
        return items[index];
    }
}