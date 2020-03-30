package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartUI {

    public void init(BufferedReader reader, Tracker tracker) throws IOException {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(reader.readLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = reader.readLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                for (int index = 0; index < tracker.findAll().length; index++) {
                    System.out.println(tracker.findAll()[index].toString());
                }
            } else if (select == 2) {
                System.out.println("Введите id");
                String id = reader.readLine();
                System.out.println("Введите новое название");
                String name = reader.readLine();
                if (tracker.replace(id, new Item(name))) {
                    System.out.println("Замена произведена успешно");
                } else {
                    System.out.println("Ошибка. Id заявки не найден");
                }
            } else if (select == 3) {
                System.out.println("Введите id для удаления");
                String id = reader.readLine();
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена успешно");
                } else {
                    System.out.println("Ошибка. Id заявки не найден");
                }
            } else if (select == 4) {
                System.out.println("Введите id для поиска товара");
                String id = reader.readLine();
                if (tracker.findById(id) != null) {
                    System.out.println(new Item(id).getName());
                } else {
                    System.out.println("Ошибка. Id заявки не найден");
                }
            } else if (select == 5) {
                System.out.println("Введите имя");
                String name = reader.readLine();
                if (tracker.findByName(name) != null) {
                    System.out.println(new Item(name).getName());
                } else {
                    System.out.println("Ошибка. Id заявки не найден");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Tracker tracker = new Tracker();
        new StartUI().init(reader, tracker);
    }
}