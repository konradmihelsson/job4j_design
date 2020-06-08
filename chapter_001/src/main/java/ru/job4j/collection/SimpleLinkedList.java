package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements Iterable<E> {

    private Node<E> begin;
    private int size;
    private int modCount;

    public void add(E value) {
        if (this.begin == null) {
            this.begin = new Node<>(value, null);
        } else {
            Node<E> last = begin;
            while (last.nextElement != null) {
                last = last.nextElement;
            }
            last.nextElement = new Node<>(value, null);
        }
        this.size++;
        this.modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> interim = this.begin;
        for (int i = 0; i != index; i++) {
            interim = this.begin.nextElement;
        }
        return interim.storage;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
            Node<E> element = begin;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (element != null);
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = element.storage;
                element = element.nextElement;
                return result;
            }
        };
    }

    private static class Node<E> {
        E storage;
        Node<E> nextElement;

        Node(E storage, Node<E> nextElement) {
            this.storage = storage;
            this.nextElement = nextElement;
        }
    }
}
