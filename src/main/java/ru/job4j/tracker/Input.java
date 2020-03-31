package ru.job4j.tracker;

import java.io.IOException;

public interface Input {
    String askStr(String question) throws IOException;

    int askInt(String question) throws IOException;
}