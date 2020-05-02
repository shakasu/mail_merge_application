package ru.job4j.logic;

import ru.job4j.model.User;
import java.util.*;

public class Logic {
    public LinkedList<User> merge(LinkedList<User> input) {
        LinkedList<User> result = new LinkedList<>();
        Set<String> merger = new HashSet<>();
        boolean allUsersAreNotUnique = true;
        do {
            User currentUser = input.pop();
            int startSize = input.size();
            for (int i = 0; i < startSize; i++) {
                User nextUser = input.pop();
                merger.addAll(nextUser.getMails());
                merger.addAll(currentUser.getMails());
                if (merger.size() == nextUser.getMails().size() + currentUser.getMails().size()) {
                    result.add(nextUser);
                } else {
                    currentUser = new User(currentUser.getName(), new HashSet<>(merger));
                }
                merger.clear();
            }
            result.add(currentUser);
            if (result.size() != startSize) {
                input = result;
            } else {
                allUsersAreNotUnique = false;
            }
        } while (allUsersAreNotUnique);
        return result;
    }
}
