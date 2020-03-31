package ru.job4j.tracker;

import java.io.IOException;

public class StartUI {

    public void init(Input input, Tracker tracker) throws IOException {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                String name = input.askStr("=== Create a new Item ====" + "\nEnter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                for (int index = 0; index < tracker.findAll().length; index++) {
                    System.out.println(tracker.findAll()[index].toString());
                }
            } else if (select == 2) {
                String id = input.askStr("Введите id: ");
                String name = input.askStr("Введите новое название: ");
                if (tracker.replace(id, new Item(name))) {
                    System.out.println("Замена произведена успешно");
                } else {
                    System.out.println("Ошибка. Id заявки не найден");
                }
            } else if (select == 3) {
                String id = input.askStr("Введите id для удаления: ");
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена успешно");
                } else {
                    System.out.println("Ошибка. Id заявки не найден");
                }
            } else if (select == 4) {
                String id = input.askStr("Введите id для поиска товара: ");
                if (tracker.findById(id) != null) {
                    System.out.println(new Item(id).getName());
                } else {
                    System.out.println("Ошибка. Id заявки не найден");
                }
            } else if (select == 5) {
                String name = input.askStr("Введите имя: ");
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
        System.out.println("\nMenu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) throws IOException {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}