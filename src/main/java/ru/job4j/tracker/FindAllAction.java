package ru.job4j.tracker;


import java.util.ArrayList;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList<Item> items = tracker.findAll();
        if (items.size() != 0) {
            for (Item item: items) {
                System.out.println("Name: " + item.getName() + " | Id: " + item.getId());
            }
        } else {
            System.out.println("No items found");
        }
        return true;
    }
}
