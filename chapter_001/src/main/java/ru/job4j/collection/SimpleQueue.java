package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size;
    private boolean inEmpty = false;

    public T poll() {
        if (!inEmpty) {
            transposition(in, out);
        }
        size--;
        inEmpty = true;
        return out.pop();
    }

    public void push(T value) {
        if (inEmpty) {
            transposition(out, in);
        }
        this.in.push(value);
        size++;
        inEmpty = false;
    }

    private void transposition(SimpleStack<T> from, SimpleStack<T> to) {
        int count = size;
        while (count != 0) {
            to.push(from.pop());
            count--;
        }
    }
}
