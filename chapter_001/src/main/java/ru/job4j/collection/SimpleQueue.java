package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size;

    public T poll() {
        T result;
        int count = size;
        while (count != 0) {
            out.push(in.pop());
            count--;
        }
        result = out.pop();
        size--;
        count = size;
        while (count != 0) {
            in.push(out.pop());
            count--;
        }
        return result;
    }

    public void push(T value) {
        this.in.push(value);
        size++;
    }
}
