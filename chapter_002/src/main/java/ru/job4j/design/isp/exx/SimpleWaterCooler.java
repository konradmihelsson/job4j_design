package ru.job4j.design.isp.exx;

public class SimpleWaterCooler implements WaterCooler {
    @Override
    public void pour() {
        System.out.println("Pour out");
    }

    @Override
    public void heatUp() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void coolDown() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void waterLevelMeasure() {
        throw new UnsupportedOperationException();
    }
}
