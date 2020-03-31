package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String askStr(String question) throws IOException {
        System.out.print(question);
        return reader.readLine();
    }

    @Override
    public int askInt(String question) throws IOException {
        System.out.print(question);
        return Integer.parseInt(reader.readLine());
    }
}
