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
        Item[] itemName = tracker.findByName(name);
        for (int index = 0; index < itemName.length; index++) {
            if (itemName[index].getName().equals(name)) {
                System.out.println(itemName[index]);
            } else {
                System.out.println("Error. Id not found");
            }
        }
        return true;
    }
}
