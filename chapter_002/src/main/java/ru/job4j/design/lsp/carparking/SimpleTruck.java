package ru.job4j.design.lsp.carparking;

public class SimpleTruck implements Vehicle {

    private int size;

    public SimpleTruck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
