package ru.job4j.tracker;

import java.io.IOException;
import java.sql.SQLException;

public class StartUI {

    public void init(Input input, Store store, UserAction[] actions) throws IOException, SQLException {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, store);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println(System.lineSeparator() + "Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) throws IOException {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateAction(), new ReplaceAction(), new DeleteAction(), new FindAllAction(), new FindByNameAction(), new FindByIdAction()
            };
            new StartUI().init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
