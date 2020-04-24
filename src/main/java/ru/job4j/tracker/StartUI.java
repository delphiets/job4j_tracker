package ru.job4j.tracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class StartUI {

    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) throws IOException {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        System.out.println(System.lineSeparator() + "Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) throws IOException {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(new CreateAction(), new FindAllAction(), new ReplaceAction(), new DeleteAction(), new FindByIdAction(), new FindByNameAction(), new ExitAction()));
        new StartUI().init(validate, tracker, actions);
    }
}