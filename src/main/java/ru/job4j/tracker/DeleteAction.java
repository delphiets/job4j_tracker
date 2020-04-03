package ru.job4j.tracker;

import java.io.IOException;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
        String id = input.askStr("=== Create a new Item ====" + System.lineSeparator() + "Enter id to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Application deleted successfully");
        } else {
            System.out.println("Error. Id not found");
        }
        return true;
    }
}
