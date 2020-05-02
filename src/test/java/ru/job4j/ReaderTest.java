package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.logic.Logic;
import ru.job4j.logic.Reader;
import ru.job4j.model.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReaderTest {
    User user1;
    User user2;
    User user3;
    User user4;
    User user5;
    User user6;

    @Before
    public void setUp() {
        user1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        user2 = new User("user2", Set.of("foo@gmail.com", "ups@pisem.net"));
        user3 = new User("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        user4 = new User("user4", Set.of("ups@pisem.net", "aaa@bbb.ru"));
        user5 = new User("user5", Set.of("xyz@pisem.net"));
        user6 = new User("user6", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"));
    }

    @Test
    public void whenRead() {
        String path = "./src/main/resources/list_of_users.txt";
        Reader reader = new Reader(path);
        assertThat(
                reader.getInput(),
                is(List.of(user1, user2, user3, user4, user5))
        );
    }

    @Test
    public void whenReadAndMerge() {
        String path = "./src/main/resources/list_of_users.txt";
        Reader reader = new Reader(path);
        Logic logic = new Logic();
        List<User> input = logic.merge(reader.getInput());
        assertThat(
                input,
                is(List.of(user6, user3))
        );
    }

    @Test
    public void whenReadAndMerge2() {
        String pathIn = "./src/main/resources/list_of_a_lot_of_users.txt";
        String pathOut = "./src/main/resources/expected.txt";
        Reader in = new Reader(pathIn);
        Reader out = new Reader(pathOut);
        Logic logic = new Logic();
        List<User> result = logic.merge(in.getInput());
        List<User> expected = out.getInput();
        assertThat(
                result,
                is(expected)
        );
    }

    @Test(expected = FileNotFoundException.class)
    public void exception() throws FileNotFoundException {
        new FileReader("a");
    }
}
