package ru.job4j.design.isp;

public class MultiTool implements Tool {
    @Override
    public void toSaw() {
        System.out.println("Do nag!");
    }

    @Override
    public void tighten() {
        System.out.println("Do tighten!");
    }

    @Override
    public void cut() {
        System.out.println("Do cut!");
    }
}
