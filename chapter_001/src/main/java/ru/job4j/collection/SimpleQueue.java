package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size;
    private boolean inEmpty = false;

    public T poll() {
        if (!inEmpty) {
            int count = size;
            while (count != 0) {
                out.push(in.pop());
                count--;
            }
        }
        size--;
        return out.pop();
    }

    public void push(T value) {
        if (inEmpty) {
            int count = size;
            while (count != 0) {
                in.push(out.pop());
                count--;
            }
        }
        this.in.push(value);
        size++;
    }
}
