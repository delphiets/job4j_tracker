package ru.job4j.tracker;

import java.io.IOException;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) throws IOException {
        String name = input.askStr("=== Create a new Item ====" + "\nEnter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItem(Tracker tracker) {
        for (int index = 0; index < tracker.findAll().length; index++) {
            System.out.println(tracker.findAll()[index].toString());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) throws IOException {
        String id = input.askStr("Введите id: ");
        String name = input.askStr("Введите новое название: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Замена произведена успешно");
        } else {
            System.out.println("Ошибка. Id заявки не найден");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) throws IOException {
        String id = input.askStr("Введите id для удаления: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно");
        } else {
            System.out.println("Ошибка. Id заявки не найден");
        }
    }

    public static void findByIdItem(Input input, Tracker tracker) throws IOException {
        String id = input.askStr("Введите id для поиска товара: ");
        if (tracker.findById(id) != null) {
            System.out.println(new Item(id).getName());
        } else {
            System.out.println("Ошибка. Id заявки не найден");
        }
    }

    public static void findByNameItem(Input input, Tracker tracker) throws IOException {
        String name = input.askStr("Введите имя: ");
        if (tracker.findByName(name) != null) {
            System.out.println(new Item(name).getName());
        } else {
            System.out.println("Ошибка. Id заявки не найден");
        }
    }

    public void init(Input input, Tracker tracker) throws IOException {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItem(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findByIdItem(input, tracker);
            } else if (select == 5) {
                StartUI.findByNameItem(input, tracker);
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