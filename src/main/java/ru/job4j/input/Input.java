package ru.job4j.input;

/**
 * Интерфейс Input - родительский интерфейс для обертки пользовательского ввода.
 * Отвязка от конкретной реализации, позволит тестировать возможные сценарии пользовательского ввода.
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);

    int askInt(String question, int max);
}
