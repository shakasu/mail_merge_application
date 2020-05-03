package ru.job4j.actions;

import ru.job4j.input.Input;
import ru.job4j.logic.Logic;

import java.util.function.Consumer;

/**
 * Класс ExitAction осуществляет действие выхода из программы.
 */
public class ExitAction extends BaseAction {

    public ExitAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Logic logic, Consumer<String> output) {
        return false;
    }
}
