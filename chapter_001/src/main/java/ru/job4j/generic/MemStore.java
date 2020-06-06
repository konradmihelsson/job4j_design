package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        try {
            this.mem.set(this.mem.indexOf(findById(id)), model);
            result = true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try {
            this.mem.remove(findById(id));
            result = true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public T findById(String id) {
        return this.mem.parallelStream().filter(T -> T.getId().equals(id))
                .findAny().orElseThrow(() -> new NoSuchElementException("Not find item by id: " + id));
    }
}
