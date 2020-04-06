package ru.job4j.tracker;

import java.io.IOException;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
        String name = input.askStr("=== Create a new Item ====" + System.lineSeparator() + "Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item: items) {
                System.out.println("Name: " + item);
        }
        } else {
            System.out.println("Name not found");
        }
        return true;
    }
}
