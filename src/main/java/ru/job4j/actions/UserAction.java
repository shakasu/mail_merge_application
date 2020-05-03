package ru.job4j.actions;

import ru.job4j.input.Input;
import ru.job4j.logic.Logic;

import java.util.function.Consumer;

/**
 * Интерфейс UserAction реализует шаблон проектирования Абстрактная фабрика.
 */
public interface UserAction {
    String info();

    boolean execute(Input input, Logic logic, Consumer<String> output);
}
