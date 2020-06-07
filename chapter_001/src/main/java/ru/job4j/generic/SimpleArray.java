package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {

    private Object[] data;
    private int position;

    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    void add(T model) {
        this.data[position++] = model;
    }

    void set(int index, T model) {
        Objects.checkIndex(index, this.data.length);
        this.data[index] = model;
    }

    void remove(int index) {
        Objects.checkIndex(index, this.data.length);
        System.arraycopy(this.data, index + 1, this.data, index, this.data.length - index - 1);
        this.data[--this.position] = null;
    }

    T get(int index) {
        return (T) this.data[index];
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (position < data.length && data[position] != null) {
                    result = true;
                }
                return result;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[position++];
            }
        };
    }
}
