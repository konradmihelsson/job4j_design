package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
        int indexById = findIndexById(id);
        if (indexById >= 0) {
            this.mem.set(indexById, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int indexById = findIndexById(id);
        if (indexById >= 0) {
            this.mem.remove(indexById);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        int indexById = findIndexById(id);
        if (indexById == -1) {
            throw new NoSuchElementException("Cannot find item with this Id");
        }
        return this.mem.get(indexById);
    }

    private int findIndexById(String id) {
        int result = -1;
        for (int i = 0; i < this.mem.size(); i++) {
            if (this.mem.get(i).getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
