package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matches {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int sum = 11;
    private static boolean step  = true;

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

        boolean game = true;

        while (game) {
            System.out.println("1. Начать игру");
            System.out.println("2. Выйти");
            int number = Integer.parseInt(reader.readLine());

            if (number == 1) {
                while (game) {
                    if (sum > 0) {
                        if (step) {
                            System.out.println("Ход первого игрока. \nОсталось: " + sum + " из 11 спичек");
                            int count = Integer.parseInt(reader.readLine());
                            Matches.gamer(count);
                            step = false;
                        } else {
                            System.out.println("Ход второго игрока.\nОсталось: " + sum + " из 11 спичек");
                            int count = Integer.parseInt(reader.readLine());
                            Matches.gamer(count);
                            step = true;
                        }
                    } else if (step) {
                        System.out.println("Выиграл второй игрок");
                        game = false;
                        break;
                    } else {
                        System.out.println("Выиграл первый игрок");
                        game = false;
                        break;
                    }
                }

            } else if (number == 2) {
                System.out.println("Игра завершена.");
                game = false;
            } else {
                System.out.println("Выбрать можно только 1 или 2 вариант. Выбрать можно только 1 или 2 вариант");
            }
        }
    }
}
