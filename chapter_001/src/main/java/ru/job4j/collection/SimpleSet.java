package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private SimpleArray<E> store = new SimpleArray<>();

    public void add(E e) {
        boolean isExist = false;
        for (E element : this.store) {
            if (element.equals(e)) {
                isExist = true;
            }
        }
        if (!isExist) {
            this.store.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return this.store.iterator();
    }
}
