package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MagicBal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Я великий Оракул. Что ты хочешь узнать?");
        String question = reader.readLine();
        int answer = new Random().nextInt(3);

        if (answer == 0) {
            System.out.println(question + "\nОтвет: Да");
        } else if (answer == 1) {
            System.out.println(question + "\nОтвет: Нет");
        } else {
            System.out.println(question + "\nОтвет: Может быть");
        }
    }
}
