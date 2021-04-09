package ru.job4j.tracker;

import java.io.IOException;
import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store store) throws IOException {
        String name = input.askStr("=== Create a new Item ====" + System.lineSeparator() + "Enter name: ");
        List<Item> items = store.findByName(name);
        if (items.size() != 0) {
            for (Item item : items) {
                System.out.printf("Name: %s%s%s%s", item.getName(), ". Id: ", item.getId(), System.lineSeparator());
            }
        } else {
            System.out.println("Name not found");
        }
        return true;
    }
}
