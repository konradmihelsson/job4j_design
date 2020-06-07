package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container;
    private int size;
    private int modCount;

    public SimpleArray() {
        this.container = new Object[10];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) this.container[index];
    }

    public void add(T model) {
        if (this.size == this.container.length) {
            extendContainerSize();
        }
        this.container[size++] = model;
        modCount++;
    }

    private void extendContainerSize() {
        Object[] newSizeContainer = new Object[this.container.length + 10];
        System.arraycopy(this.container, 0, newSizeContainer, 0, this.size);
        this.container = newSizeContainer;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int position = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (position != size);
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[position++];
            }
        };
    }
}
