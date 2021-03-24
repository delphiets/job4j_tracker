package ru.job4j.tracker;

import java.io.IOException;
import java.sql.SQLException;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store store) throws IOException, SQLException {
        String id = input.askStr("=== Create a new Item ====" + System.lineSeparator() + "Enter id: ");
        String name = input.askStr("Enter new name: ");
        if (store.replace(id, new Item(name))) {
            System.out.println("Successful replacement");
        } else {
            System.out.println("Error. Id not found");
        }
        return true;
    }
}
