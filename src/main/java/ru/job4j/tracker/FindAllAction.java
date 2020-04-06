package ru.job4j.tracker;

import java.io.IOException;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            for (Item item: items) {
                System.out.println("Name: " + item.getName() + " | Id: " + item.getId());
            }
        } else {
            System.out.println("No items found");
        }
        return true;
    }
}
