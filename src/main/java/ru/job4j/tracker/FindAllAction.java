package ru.job4j.tracker;

import java.io.IOException;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
        for (Item item: tracker.findAll()) {
                System.out.println("Name: " + item.getName() + " | Id: " + item.getId());
        }
        return true;
    }
}
