package ru.job4j.logic;

import ru.job4j.model.User;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс Reader отвечает за чтение исходных данных из файла и занесения их в связанный список.
 */
public class Reader {
    private final String path;
    private LinkedList<User> input = new LinkedList<>();
    private final String comment = "//";
    private final String separator = "->";
    private final String comma = ",";

    public LinkedList<User> getInput() {
        return input;
    }

    public Reader(String path) {
        this.path = path;
        load();
    }

    private void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(line -> !line.startsWith(comment)
            && line.contains(separator)
            && !line.startsWith(separator))
                    .forEach(line -> {
                        Set<String> set = Arrays.stream(line.split(separator)[1].split(comma)).collect(Collectors.toSet());
                        input.add(new User(line.split(separator)[0], set));
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
