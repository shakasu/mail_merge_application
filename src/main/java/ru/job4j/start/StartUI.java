package ru.job4j.start;

import ru.job4j.input.ConsoleInput;
import ru.job4j.input.Input;
import ru.job4j.input.ValidateInput;
import ru.job4j.logic.Logic;

import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Logic logic;
    private final Consumer<String> output;

    public StartUI(Input input, Logic logic, Consumer<String> output) {
        this.input = input;
        this.logic = logic;
        this.output = output;
    }

    public void init() {
        Menu menu = new Menu(this.input, this.logic, this.output);
        menu.fillActions();
        boolean run = true;
        while (run) {
            menu.show();
            run = menu.select(input.askInt("Select: ", menu.size() - 1));
        }
    }

    public static void main(String[] args) {
    new StartUI(new ValidateInput(new ConsoleInput()), new Logic(), System.out::println).init();
    }
}
