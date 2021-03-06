package ru.job4j.input;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Класс ValidateInput будет пропускать через себя ввод через ConsoleInput.
 * Для того, чтобы подвергать пользовательский ввод валидации.
 * В текущем сценарии учтены:
 * 1) выбор пункта не из меню.
 * 2) ввод не чисел при выборе пункта меню.
 * 3) ввод не существующего пути для исходных данных.
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        boolean invalid = true;
        String value = "-1";
        do {
            try {
                value = input.askStr(question);
                new FileReader(value);
                invalid = false;
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("File not found, please try again: ");
            }
        } while (invalid);
        return value;
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
