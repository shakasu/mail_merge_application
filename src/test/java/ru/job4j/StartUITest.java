package ru.job4j;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import ru.job4j.input.Input;
import ru.job4j.input.StabInput;
import ru.job4j.logic.Logic;
import ru.job4j.logic.Reader;
import ru.job4j.model.User;
import ru.job4j.start.StartUI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };
    private final Logic logic = new Logic();
    private static final String LN = System.lineSeparator();
    private String menu = String.format("0. Merge.%s%s1. Exit.%s%s", LN, LN, LN, LN);
    private String path = "./src/main/resources/list_of_users.txt";

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenShowMenu() {
        Input input = new StabInput(new String[]{"1"});
        new StartUI(input, logic, output).init();
        assertThat(new String(this.out.toByteArray()), is(menu));
    }

    @Test
    public void mergeMails() {
        Input input = new StabInput(new String[] {"0", "./src/main/resources/list_of_users.txt", "1"});
        new StartUI(input, logic, output).init();
        List<User> result = logic.merge((new Reader(path)).getInput());
        String rsl = String.format("%sMerging mails of users was successful.%n%s%s%s", menu, result.toString(), LN, menu);
        assertThat(new String(this.out.toByteArray()), is(rsl));
    }
}
