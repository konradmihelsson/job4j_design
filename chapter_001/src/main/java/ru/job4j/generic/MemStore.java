package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        Optional<T> itemById = findById(id);
        if (itemById.isPresent()) {
            this.mem.set(this.mem.indexOf(itemById.get()), model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        Optional<T> itemById = findById(id);
        if (itemById.isPresent()) {
            this.mem.remove(itemById.get());
            result = true;
        }
        return result;
    }

    @Override
    public Optional<T> findById(String id) {
        return this.mem.parallelStream().filter(T -> T.getId().equals(id))
                .findAny();
    }
}
