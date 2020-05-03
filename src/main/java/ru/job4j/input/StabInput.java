package ru.job4j.input;

/**
 * StabInput - "класс-заглушка", им будет имитирован пользовательский ввод. В JUnit тестах он заменит ConsoleInput.
 */
public class StabInput implements Input {
    private final String[] answers;
    private int cursor = 0;

    public StabInput(String[] answer) {
        this.answers = answer;
    }

    @Override
    public String askStr(String question) {
        return answers[cursor++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        return askInt(question);
    }
}
