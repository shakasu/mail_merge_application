package ru.job4j.actions;

/**
 * Класс BaseAction и его наследники реализуют шаблон проектирования Фабричный метод.
 */
public abstract class BaseAction implements UserAction {
    private final String name;
    private final int key;

    protected BaseAction(final int key, final String name) {
        this.name = name;
        this.key = key;
    }

    @Override
    public String info() {
        return String.format("%s. %s%n", this.key, this.name);
    }
}