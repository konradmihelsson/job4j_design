package ru.job4j.design.isp;

public class MicroWave implements Cooker {
    @Override
    public void heat() {
        System.out.println("Heating");
    }

    @Override
    public void microwave() {
        System.out.println("Microwaving");
    }

    @Override
    public void timer() {
        System.out.println("Timer is starting");
    }
}
