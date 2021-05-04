package ru.job4j.design.isp;

public class Saw implements Tool {
    @Override
    public void toSaw() {
        System.out.println("Do nag!");
    }

    @Override
    public void tighten() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cut() {
        throw new UnsupportedOperationException();
    }
}
