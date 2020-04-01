package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matches {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int sum = 11;
    private static int count = 0;
    private static String act;

    public static int gamer(int count) throws IOException {
        boolean game = true;
        while (game) {
            if (count > 0 && count <= 3) {
                sum -= count;
                game = false;
            } else {
                System.out.println("Введено некоректное число. Попробуйте снова");
                count = Integer.parseInt(reader.readLine());
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Игра 11 спичек.");
        System.out.println("\nПравила игры. \nНа столе лежат 11 спичек. \nДва игрока по очереди берут от 1 до 3 спичек. \nВыигрывает тот, кто забрал последние спички.\n");

        boolean menu = true;

        while (menu) {
            System.out.println("1. Начать игру");
            System.out.println("2. Выйти");
            int number = Integer.parseInt(reader.readLine());

            if (number == 1) {
                while (true) {
                    if (sum > 0) {
                        act = count % 2 == 0 ? "первый" : "второй";
                        count++;
                        System.out.println("Ходит " + act + " игрок. \nОсталось: " + sum + " из 11 спичек");
                        int tell = Integer.parseInt(reader.readLine());
                        Matches.gamer(tell);
                    } else {
                        System.out.println("Выиграл " + act + " игрок\n");
                        sum = 11;
                        count = 0;
                        break;
                    }
                }
            } else if (number == 2) {
                System.out.println("Игра завершена.");
                menu = false;
            } else {
                System.out.println("Выбрать можно только 1 или 2 вариант. Выбрать можно только 1 или 2 вариант");
            }
        }
    }
}
