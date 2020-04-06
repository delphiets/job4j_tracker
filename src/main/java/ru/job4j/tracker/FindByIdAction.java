package ru.job4j.tracker;

import java.io.IOException;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
        String id = input.askStr("=== Create a new Item ====" + System.lineSeparator() + "Enter id to search for goods: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Id: " + item);
        } else {
            System.out.println("Error. Id not found");
        }
        return true;
    }
}
