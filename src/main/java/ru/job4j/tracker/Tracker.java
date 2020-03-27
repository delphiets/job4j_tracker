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

        return Arrays.copyOf(items, size);
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
        return Arrays.copyOf(items, count);
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

    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = indexOf(id); // берет индекс ячейки
        if (index != -1) { // проверяет что index не -1
         String nameItem = item.getName(); // берем имя заявки
         items[index].setName(nameItem); // заменяем имя заявки
         item.setId(id); // присваиваем старое айди
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = indexOf(id);

        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
            result = true;
        }
        return result;
    }
}