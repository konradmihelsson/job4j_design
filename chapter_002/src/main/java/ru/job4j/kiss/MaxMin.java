package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getByCondition(value, comparator, i -> i > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getByCondition(value, comparator, i -> i < 0);
    }

    private <T> T getByCondition(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T result = null;
        for (T t : value) {
            if (predicate.test(comparator.compare(t, result))) {
                result = t;
            }
        }
        return result;
    }
}
