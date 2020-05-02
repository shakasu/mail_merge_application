package ru.job4j.actions;

import ru.job4j.input.Input;
import ru.job4j.logic.Logic;
import ru.job4j.logic.Reader;
import ru.job4j.model.User;

import java.util.List;
import java.util.function.Consumer;

public class MergeMails extends BaseAction {
    public MergeMails(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Logic logic, Consumer<String> output) {
        String path = input.askStr("Enter path: ");
        List<User> result = logic.merge((new Reader(path)).getInput());
        output.accept(String.format("Merging mails of users was successful.%n%s", result.toString()));
        return true;
    }
}
