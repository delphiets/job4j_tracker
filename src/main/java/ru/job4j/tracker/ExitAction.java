package ru.job4j.tracker;

import java.io.IOException;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
        return false;
    }
}