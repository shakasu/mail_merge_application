package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.logic.Logic;
import ru.job4j.model.User;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    LinkedList<User> input = new LinkedList<>();
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
        input.add(user1);
        input.add(user2);
        input.add(user3);
        input.add(user4);
        input.add(user5);
    }

    @Test
    public void merge() {
        Logic logic = new Logic();
        LinkedList<User> result = logic.merge(input);
        List<User> expected = List.of(user6, user3);
        assertThat(result, is(expected));
    }

    @Test
    public void print() {
        System.out.println(user6);
    }
}
