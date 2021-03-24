
package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class MemTracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    private String generateId() {
        return String.valueOf(ids++);
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        for (int index = 0; index < this.items.size(); index++) {
            Item item = this.items.get(index);
            if (item.getName().equals(key)) {
                items.add(item);
            }
        }
        return items;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            items.set(index, item);
            item.setId(id);
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
           items.remove(index);
            result = true;
        }
        return result;
    }
}
