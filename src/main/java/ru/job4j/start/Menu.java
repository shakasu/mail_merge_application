package ru.job4j.start;

import ru.job4j.actions.ExitAction;
import ru.job4j.actions.MergeMails;
import ru.job4j.actions.UserAction;
import ru.job4j.input.Input;
import ru.job4j.logic.Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Menu {
    private final Input input;
    private final Logic logic;
    private final Consumer<String> output;

    private final List<UserAction> actions = new ArrayList<>();

    public Menu(Input input, Logic logic, Consumer<String> output) {
        this.input = input;
        this.logic = logic;
        this.output = output;
    }

    public void fillActions() {
        this.actions.add(0, new MergeMails(0, "Merge."));
        this.actions.add(1, new ExitAction(1, "Exit."));
    }

    public boolean select(int key) {
        return this.actions.get(key).execute(this.input, this.logic, output);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    public int size() {
        return this.actions.size();
    }
}
