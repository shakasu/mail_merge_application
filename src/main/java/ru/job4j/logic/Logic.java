package ru.job4j.logic;

import ru.job4j.model.User;
import java.util.*;

/**
 * Класс Logic является ключевым и осуществляет искомый алгоритм - объединять пользователей.
 * Приблизительная временная сложность программы - O(n * log(n)),
 * получается из вложенного цикла, где число итераций внутреннего постоянно уменьшается.
 * За счет очереди поочередно сравнивается каждый элемент исходного листа.
 * В зависимости от результата сравнения, происходит заполнение второй очереди result.
 * В конце внешней итерации result становится основной очередью, тем самым сокращая количество внутренних итераций.
 * Наличие пересечения определяется через класс Set: в множество добавляются адреса двух пользователей.
 * Если длина Set равна сумме длин их списков почты по отдельности - пересечения нет.
 * allUsersAreNotUnique - данное условия прекращает внешний цикл, если после внутренней итерации новых слияний не произошло.
 */
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
