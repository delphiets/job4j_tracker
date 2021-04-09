package ru.job4j.tracker;

import java.io.IOException;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store store) throws IOException {
        String id = input.askStr("=== Create a new Item ====" + System.lineSeparator() + "Enter id to search for goods: ");
        Item item = store.findById(id);
        if (item != null) {
            System.out.printf("Name: %s%s%s" + item.getName(), ". Id: ", item.getId());
        } else {
            System.out.println("Error. Name not found");
        }
        return true;
    }
}
