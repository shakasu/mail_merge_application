package ru.job4j.model;

import java.util.*;

public class User {
    private final String name;
    private final Set<String> mails;

    public User(String name, Set<String> set) {
        this.name = name;
        this.mails = set;
    }

    public String getName() {
        return name;
    }

    public Set<String> getMails() {
        return mails;
    }

    @Override
    public String toString() {
        return String.format("The user %s has the following accounts: %s%n", name, mails);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return mails.equals(user.mails);
    }

    @Override
    public int hashCode() {
        return mails != null ? mails.hashCode() : 0;
    }
}
