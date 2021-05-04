package ru.job4j.design.isp;

public class Bake implements Cooker {
    @Override
    public void heat() {
        System.out.println("Heating");
    }

    @Override
    public void microwave() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void timer() {
        throw new UnsupportedOperationException();
    }
}
