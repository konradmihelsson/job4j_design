package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int inSize;
    private int outSize;

    public T poll() {
        if (outSize == 0) {
            transposition();
        }
        outSize--;
        return out.pop();
    }

    public void push(T value) {
        this.in.push(value);
        inSize++;
    }

    private void transposition() {
        while (inSize != 0) {
            out.push(in.pop());
            inSize--;
            outSize++;
        }
    }
}
